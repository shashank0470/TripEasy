package com.example.MajorProject.service;


import com.example.MajorProject.Dto.request.BookingRequest;
import com.example.MajorProject.Dto.response.BookingResponse;
import com.example.MajorProject.exception.CabNotAvailable;
import com.example.MajorProject.exception.CustomerNotFound;
import com.example.MajorProject.model.Booking;
import com.example.MajorProject.model.Cab;
import com.example.MajorProject.model.Customer;
import com.example.MajorProject.model.Driver;
import com.example.MajorProject.repository.BookingRepository;
import com.example.MajorProject.repository.CabRepository;
import com.example.MajorProject.repository.CustomerRepository;
import com.example.MajorProject.repository.DriverRepository;
import com.example.MajorProject.transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) throws CustomerNotFound{
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFound("Customer is not registered");
        }

        Customer customer = optionalCustomer.get();

        Cab availableCab = cabRepository.getAvailableCabRandomly();
        if(availableCab == null){
            throw new CabNotAvailable("Cab is not available");
        }

        Booking booked = BookingTransformer.BookingRequestToBooking(bookingRequest, availableCab.getPer_km_rate());
        Booking savedBooking = bookingRepository.save(booked);

        availableCab.setAvailable(false);
        customer.getBooking().add(booked);

        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBooking().add(booked);

        Driver savedDriver = driverRepository.save(driver);
        Customer savedCustomer = customerRepository.save(customer);

        sendEmail(savedCustomer);

        return BookingTransformer.bookingToBookingResponse(booked, savedCustomer,savedDriver, availableCab);
    }

    private void sendEmail(Customer customer){
        String text = "Congrates! " + customer.getName() + " your cab is booked";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tm4811357@gmail.com");
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("Cab Booked");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
    }
}

