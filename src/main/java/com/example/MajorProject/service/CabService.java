package com.example.MajorProject.service;

import com.example.MajorProject.Dto.request.CabRequest;
import com.example.MajorProject.Dto.request.DriverRequest;
import com.example.MajorProject.Dto.response.CabResponse;
import com.example.MajorProject.exception.DriverNotFound;
import com.example.MajorProject.model.Cab;
import com.example.MajorProject.model.Driver;
import com.example.MajorProject.repository.CabRepository;
import com.example.MajorProject.repository.DriverRepository;
import com.example.MajorProject.transformers.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    CabRepository cabRepository;

    @Autowired
    DriverRepository driverRepository;

    public CabResponse registerCab(CabRequest cabRequest, int driverId) throws DriverNotFound {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);

        if(optionalDriver.isEmpty()){
            throw new DriverNotFound("Driver not found");
        }
        Cab cab = CabTransformer.cabRequestToCab(cabRequest);
        Driver driver = optionalDriver.get();
        driver.setCab(cab);

        Driver savedDriver = driverRepository.save(driver);

        return CabTransformer.cabToCabResponse(savedDriver.getCab(), savedDriver);

    }
}
