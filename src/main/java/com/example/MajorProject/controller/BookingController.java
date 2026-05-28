package com.example.MajorProject.controller;

import com.example.MajorProject.Dto.request.BookingRequest;
import com.example.MajorProject.Dto.response.BookingResponse;
import com.example.MajorProject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book/customer/{id}")
        public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                       @PathVariable("id") int customerId){
                return bookingService.bookCab(bookingRequest, customerId);

        }
}
