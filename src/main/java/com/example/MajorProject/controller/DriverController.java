package com.example.MajorProject.controller;


import com.example.MajorProject.Dto.request.DriverRequest;
import com.example.MajorProject.Dto.response.DriverResponse;
import com.example.MajorProject.exception.DriverNotFound;
import com.example.MajorProject.model.Driver;
import com.example.MajorProject.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/add-driver")
    public DriverResponse addDriver(@RequestBody DriverRequest driverRequest){
        return driverService.addDriver(driverRequest);
    }

    @GetMapping("/get-driver/{driverID}")
    public DriverResponse getDriver(@PathVariable("driverID") int driverID) throws DriverNotFound {
        return driverService.getDriver(driverID);
    }

    @DeleteMapping("/delete-driver/{driverId}")
    public DriverResponse deleteDriverById(@PathVariable("driverId") int driverId) throws DriverNotFound{
        return driverService.deleteDriverById(driverId);
    }

    @PutMapping("/update-driver/{id}")
    public DriverResponse updateDriver(@RequestBody DriverRequest driverRequest, @PathVariable int id) throws DriverNotFound{

        return driverService.updateDriver(driverRequest, id);
    }
}
