package com.example.MajorProject.transformers;

import com.example.MajorProject.Dto.request.DriverRequest;
import com.example.MajorProject.Dto.response.DriverResponse;
import com.example.MajorProject.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
            return Driver.builder()
                    .name(driverRequest.getName())
                    .age(driverRequest.getAge())
                    .emailId(driverRequest.getEmailId())
                    .gender(driverRequest.getGender())
        .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){

        return DriverResponse.builder()
                        .name(driver.getName())
                        .age(driver.getAge())
                        .emailId(driver.getEmailId())
                        .gender(driver.getGender())
                        .driverID(driver.getDriverID())
                        .build();

    }
}
