package com.example.MajorProject.service;

import com.example.MajorProject.Dto.request.CustomerRequest;
import com.example.MajorProject.Dto.response.CustomerResponse;
import com.example.MajorProject.Enum.Gender;
import com.example.MajorProject.exception.CustomerNotFound;
import com.example.MajorProject.model.Customer;
import com.example.MajorProject.repository.BookingRepository;
import com.example.MajorProject.repository.CustomerRepository;
import com.example.MajorProject.transformers.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest){
        //RequestDTO --> Entity(Here we are converting the requestdto to entity )
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        Customer saveCustomer = customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponse(saveCustomer);
    }

    public CustomerResponse getCustomer(int customerID) throws CustomerNotFound {
        //findbyid find the primary key
        Optional<Customer> optionalCustomer =  customerRepository.findById(customerID);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFound("Invalid CustomerID");
        }
        Customer savedCustomer =  optionalCustomer.get();
        //Saved Entity to ResponseDTO
        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(savedCustomer);

        return customerResponse;
    }



    public List<CustomerResponse> getAllCustomer() {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getByGender(Gender gender) {
        List<Customer> customers =  customerRepository.findByGender(gender);

        //Entity to DTOs conversion
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }

    public List<CustomerResponse> getByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = customerRepository.findByGenderAndAge(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;

    }

    public CustomerResponse updateCustomer(CustomerRequest customerRequest, int id) throws CustomerNotFound {
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()){
            throw new CustomerNotFound("No customer found for id: " + id);
        }

        Customer updateCustomer = customer.get();

        updateCustomer.setName(customerRequest.getName());
        updateCustomer.setAge(customerRequest.getAge());
        updateCustomer.setEmailId(customerRequest.getEmailId());
        updateCustomer.setGender(customerRequest.getGender());

        customerRepository.save(updateCustomer);

        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(updateCustomer);

        return customerResponse;

    }

    public void deleteCustomer(int id) throws CustomerNotFound {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isEmpty()) {
            throw new CustomerNotFound("No customer found for id: " + id);
        }

        customerRepository.deleteById(id);
        bookingRepository.deleteBookingsByCustomerId(id);
    }
}
