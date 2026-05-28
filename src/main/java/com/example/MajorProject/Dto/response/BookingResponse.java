package com.example.MajorProject.Dto.response;


import com.example.MajorProject.Enum.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {

    private String pickup;

    private String destination;

    private double trip_distance_in_Km;

    @Enumerated(value = EnumType.STRING)
    private TripStatus trip_status;

    private double bill_amount;

    Date bookedAt;

    Date lastUpdateAt;

    CustomerResponse customer;

    CabResponse cab;
}
