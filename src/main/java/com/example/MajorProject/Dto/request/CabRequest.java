package com.example.MajorProject.Dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CabRequest {
    private String cabNumber;
    private String carModel;
    private double per_km_rate;
}
