package com.example.MajorProject.Dto.request;

import com.example.MajorProject.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DriverRequest {
    private String name;
    private int age;
    private String emailId;
    Gender gender;
}
