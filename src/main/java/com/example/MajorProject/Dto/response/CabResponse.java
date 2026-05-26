package com.example.MajorProject.Dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CabResponse {
    private String cabNumber;

    private String carModel;

    private double per_km_rate;

    private boolean available;

    private DriverResponse driver;
}
