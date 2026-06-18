package com.example.MajorProject.Dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CabRequest {

    @NotBlank(message = "Cab number is required")
    private String cabNumber;

    @NotBlank(message = "Car model is required")
    private String carModel;

    @Positive(message = "Per km rate must be greater than 0")
    private double per_km_rate;
}
