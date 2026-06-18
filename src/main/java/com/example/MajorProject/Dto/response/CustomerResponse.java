package com.example.MajorProject.Dto.response;

import com.example.MajorProject.Enum.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private Integer customerID;
    private String name;
    private int age;
    private Gender gender;
    private String emailId;
}
