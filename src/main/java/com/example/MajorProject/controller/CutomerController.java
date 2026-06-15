package com.example.MajorProject.controller;

import com.example.MajorProject.Dto.request.CustomerRequest;
import com.example.MajorProject.Dto.response.CustomerResponse;
import com.example.MajorProject.Enum.Gender;
import com.example.MajorProject.exception.CustomerNotFound;
import com.example.MajorProject.model.Customer;
import com.example.MajorProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CutomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerID) throws CustomerNotFound {

        return customerService.getCustomer(customerID);
    }
    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getByGender(@PathVariable Gender gender){
        return customerService.getByGender(gender);
    }

    @GetMapping("/get")
    public List<CustomerResponse> getByGenderAndAge(@RequestParam Gender gender,
                                                    @RequestParam int age){
        return customerService.getByGenderAndAge(gender, age);
    }

    @PutMapping("/update/{id}")
    public CustomerResponse updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable int id) throws CustomerNotFound{
            return customerService.updateCustomer(customerRequest, id);
    }

    @DeleteMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}
