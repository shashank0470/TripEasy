package com.example.MajorProject.Dto.request;

import com.example.MajorProject.Enum.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRequest {

    private String pickup;

    private String destination;

    private double trip_distance_in_Km;

    private double bill_amount;

    @Enumerated(value = EnumType.STRING)
    private TripStatus trip_status;

}
