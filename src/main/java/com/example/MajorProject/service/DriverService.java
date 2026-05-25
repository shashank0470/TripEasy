package com.example.MajorProject.service;


import com.example.MajorProject.Dto.request.DriverRequest;
import com.example.MajorProject.Dto.response.DriverResponse;
import com.example.MajorProject.exception.DriverNotFound;
import com.example.MajorProject.model.Driver;
import com.example.MajorProject.repository.DriverRepository;
import com.example.MajorProject.transformers.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {
            Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);

            Driver savedDriver =  driverRepository.save(driver);

            return DriverTransformer.driverToDriverResponse(savedDriver);
    }

    public DriverResponse getDriver(int driverID) throws DriverNotFound {
        Optional<Driver> driver = driverRepository.findById(driverID);
        if(driver.isEmpty()){
            throw new DriverNotFound("Driver not found");
        }
        Driver yourDriver = driver.get();

        DriverResponse responseDriver = DriverTransformer.driverToDriverResponse(yourDriver);

        return responseDriver;
    }

    public DriverResponse deleteDriverById(int driverId) throws DriverNotFound{
        Optional<Driver> driver = driverRepository.findById(driverId);

        if(driver.isEmpty()){
            throw new DriverNotFound("driver not found");
        }
        Driver driverToDelete = driver.get();

        DriverResponse deleteDriverResponse = DriverTransformer.driverToDriverResponse(driverToDelete);

        driverRepository.deleteById(driverId);

        return deleteDriverResponse;
    }
}
