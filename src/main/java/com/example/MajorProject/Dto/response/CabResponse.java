package com.example.MajorProject.Dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {
    private String cabNumber;

    private String carModel;

    private double per_km_rate;

    private boolean available;

    private DriverResponse driver;
}
