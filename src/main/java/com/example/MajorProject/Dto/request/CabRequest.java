package com.example.MajorProject.Dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CabRequest {
    private String cabNumber;
    private String carModel;
    private double per_km_rate;
}
