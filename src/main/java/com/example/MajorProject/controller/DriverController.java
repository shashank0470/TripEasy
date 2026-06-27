package com.example.MajorProject.controller;

import com.example.MajorProject.Dto.request.DriverRequest;
import com.example.MajorProject.Dto.response.DriverResponse;
import com.example.MajorProject.common.ApiResponse;
import com.example.MajorProject.service.DriverService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    Logger log = LoggerFactory.getLogger(DriverController.class);

    @PostMapping("/add-driver")
    public ApiResponse<DriverResponse> addDriver(@Valid @RequestBody DriverRequest driverRequest) {
        log.info("Request Body of driver is recieved from the driver");
        return ApiResponse.success(driverService.addDriver(driverRequest));
    }

    @GetMapping("/get-driver/{driverID}")
    public ApiResponse<DriverResponse> getDriver(@PathVariable("driverID") int driverID) {
        return ApiResponse.success(driverService.getDriver(driverID));
    }

    @DeleteMapping("/delete-driver/{driverId}")
    public ApiResponse<DriverResponse> deleteDriverById(@PathVariable("driverId") int driverId) {
        return ApiResponse.success(driverService.deleteDriverById(driverId));
    }

    @PutMapping("/update-driver/{id}")
    public ApiResponse<DriverResponse> updateDriver(@Valid @RequestBody DriverRequest driverRequest,
                                                    @PathVariable int id) {
        return ApiResponse.success(driverService.updateDriver(driverRequest, id));
    }
}
