package com.example.MajorProject.model;


import com.example.MajorProject.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverID;
    private String name;
    private int age;

    @Column(unique = true, nullable = false)
    private String emailId;

    Gender gender;

    @OneToMany
    @JoinColumn(name = "driver_Id")
    List<Booking> booking = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_Id")
    Cab cab;
}
