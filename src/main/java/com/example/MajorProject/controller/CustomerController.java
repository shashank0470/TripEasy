package com.example.MajorProject.controller;

import com.example.MajorProject.Dto.request.CustomerRequest;
import com.example.MajorProject.Dto.response.CustomerResponse;
import com.example.MajorProject.Enum.Gender;
import com.example.MajorProject.common.ApiResponse;
import com.example.MajorProject.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ApiResponse<CustomerResponse> addCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        return ApiResponse.success(customerService.addCustomer(customerRequest));
    }

    @GetMapping("/get/customer-id/{id}")
    public ApiResponse<CustomerResponse> getCustomer(@PathVariable("id") int customerID) {
        return ApiResponse.success(customerService.getCustomer(customerID));
    }

    @GetMapping("/getAllCustomer")
    public ApiResponse<List<CustomerResponse>> getAllCustomer() {
        return ApiResponse.success(customerService.getAllCustomer());
    }

    @GetMapping("/get/gender/{gender}")
    public ApiResponse<List<CustomerResponse>> getByGender(@PathVariable Gender gender) {
        return ApiResponse.success(customerService.getByGender(gender));
    }

    @GetMapping("/get")
    public ApiResponse<List<CustomerResponse>> getByGenderAndAge(@RequestParam Gender gender,
                                                                 @RequestParam int age) {
        return ApiResponse.success(customerService.getByGenderAndAge(gender, age));
    }

    @PutMapping("/update/{id}")
    public ApiResponse<CustomerResponse> updateCustomer(@Valid @RequestBody CustomerRequest customerRequest,
                                                        @PathVariable int id) {
        return ApiResponse.success(customerService.updateCustomer(customerRequest, id));
    }

    @DeleteMapping("/delete-customer/{id}")
    public ApiResponse<Void> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ApiResponse.success("Customer deleted successfully", null);
    }
}
