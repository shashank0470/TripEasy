package com.example.MajorProject.controller;

import com.example.MajorProject.Dto.request.CabRequest;
import com.example.MajorProject.Dto.response.CabResponse;
import com.example.MajorProject.common.ApiResponse;
import com.example.MajorProject.service.CabService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;

    @PostMapping("/register-cab/{id}")
    public ApiResponse<CabResponse> registerCab(@Valid @RequestBody CabRequest cabRequest,
                                                @PathVariable("id") int driverId) {
        return ApiResponse.success(cabService.registerCab(cabRequest, driverId));
    }
}
