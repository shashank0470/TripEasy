package com.example.MajorProject.transformers;

import com.example.MajorProject.Dto.request.CabRequest;
import com.example.MajorProject.Dto.response.CabResponse;
import com.example.MajorProject.model.Cab;
import com.example.MajorProject.model.Driver;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .carModel(cabRequest.getCarModel())
                .per_km_rate(cabRequest.getPer_km_rate())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .carModel(cab.getCarModel())
                .cabNumber(cab.getCabNumber())
                .per_km_rate(cab.getPer_km_rate())
                .available(cab.isAvailable())
                .driver(DriverTransformer.driverToDriverResponse(driver))
                .build();
    }
}
