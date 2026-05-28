package com.example.MajorProject.transformers;

import com.example.MajorProject.Dto.request.CustomerRequest;
import com.example.MajorProject.Dto.response.CustomerResponse;
import com.example.MajorProject.model.Customer;

public class CustomerTransformer {
    // DTO → Entity
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        //here we have used builder, which makes it more efficient and easier to write the code and
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .gender(customerRequest.getGender())
                .emailId(customerRequest.getEmailId())
                .build();
        return customer;
    }

    // Entity → DTO
    public static CustomerResponse customerToCustomerResponse(Customer customer){
        CustomerResponse customerResponse = CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .build();

        return customerResponse;
    }
}
