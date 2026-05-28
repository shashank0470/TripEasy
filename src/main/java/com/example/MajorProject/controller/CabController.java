package com.example.MajorProject.controller;

import com.example.MajorProject.Dto.request.CabRequest;
import com.example.MajorProject.Dto.response.CabResponse;
import com.example.MajorProject.exception.DriverNotFound;
import com.example.MajorProject.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;


    @PostMapping("/register-cab/{id}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,
                                   @PathVariable("id") int driverId) throws DriverNotFound {
        return cabService.registerCab(cabRequest, driverId);
    }
}
