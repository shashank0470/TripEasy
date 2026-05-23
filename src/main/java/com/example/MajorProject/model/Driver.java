package com.example.MajorProject.model;


import com.example.MajorProject.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverID;
    private String name;
    private int age;
    Gender gender;

    @OneToMany
    @JoinColumn(name = "driver_Id")
    List<Booking> booking = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_Id")
    Cab cab;
}
