package com.example.MajorProject.controller;

import com.example.MajorProject.Dto.request.BookingRequest;
import com.example.MajorProject.Dto.response.BookingResponse;
import com.example.MajorProject.common.ApiResponse;
import com.example.MajorProject.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book/customer/{id}")
    public ApiResponse<BookingResponse> bookCab(@Valid @RequestBody BookingRequest bookingRequest,
                                                @PathVariable("id") int customerId) {
        return ApiResponse.success(bookingService.bookCab(bookingRequest, customerId));
    }
}
