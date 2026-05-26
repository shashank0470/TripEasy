package com.example.MajorProject.Dto.response;


import com.example.MajorProject.Enum.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class DriverResponse {
    private int driverID;
    private String name;
    private int age;
    private String emailId;
    Gender gender;
}
