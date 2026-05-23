package com.example.MajorProject.service;

import com.example.MajorProject.Dto.request.CustomerRequest;
import com.example.MajorProject.Dto.response.CustomerResponse;
import com.example.MajorProject.Enum.Gender;
import com.example.MajorProject.exception.CustomerNotFound;
import com.example.MajorProject.model.Customer;
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

    public CustomerResponse addCustomer(CustomerRequest customerRequest){
        //RequestDTO --> Entity(Here we are converting the requestdto to entity )
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        Customer saveCustomer =  customerRepository.save(customer);

        //Saved Entity to ResponseDTO
        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(customer);

        return customerResponse;
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



    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
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

//    public void deleteCustomer(int customerID){
//        if (!customerRepository.findAll(customerID)) {
//
//
//        }
//        customerRepository.deleteAll(customerID);
//    }
}
