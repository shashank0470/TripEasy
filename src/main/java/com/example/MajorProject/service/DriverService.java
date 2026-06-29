package com.example.MajorProject.service;


import com.example.MajorProject.Dto.request.DriverRequest;
import com.example.MajorProject.Dto.response.DriverResponse;
import com.example.MajorProject.exception.DriverNotFound;
import com.example.MajorProject.model.Driver;
import com.example.MajorProject.repository.DriverRepository;
import com.example.MajorProject.transformers.DriverTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public DriverResponse updateDriver(DriverRequest driverRequest, int id) throws DriverNotFound {
        Optional<Driver> driver = driverRepository.findById(id);

        if(!driver.isPresent()){
            throw new DriverNotFound("Driver is not found");
        }

        Driver savedDriver = driver.get();
        savedDriver.setName(driverRequest.getName());
        savedDriver.setAge(driverRequest.getAge());
        savedDriver.setEmailId(driverRequest.getEmailId());
        savedDriver.setGender(driverRequest.getGender());

        driverRepository.save(savedDriver);
        DriverResponse driverResponse = DriverTransformer.driverToDriverResponse(savedDriver);

        return driverResponse;
    }

    public List<DriverResponse> getAllDrivers() {
        List<DriverResponse> responses = new ArrayList<>();
        for (Driver driver : driverRepository.findAll()) {
            responses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return responses;
    }

}
