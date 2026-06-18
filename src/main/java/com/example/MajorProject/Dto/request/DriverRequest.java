package com.example.MajorProject.Dto.request;

import com.example.MajorProject.Enum.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 18, message = "Driver must be at least 18 years old")
    @Max(value = 150, message = "Age must be at most 150")
    private int age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String emailId;

    @NotNull(message = "Gender is required")
    private Gender gender;
}
