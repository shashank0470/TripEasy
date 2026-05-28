package com.example.MajorProject.Dto.request;

import com.example.MajorProject.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerRequest {
    private String name;
    private int age;
    private Gender gender;
    private String emailId;
}
