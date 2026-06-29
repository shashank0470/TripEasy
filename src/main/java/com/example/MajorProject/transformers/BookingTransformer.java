package com.example.MajorProject.transformers;

import com.example.MajorProject.Dto.request.BookingRequest;
import com.example.MajorProject.Dto.request.CabRequest;
import com.example.MajorProject.Dto.response.BookingResponse;
import com.example.MajorProject.Enum.TripStatus;
import com.example.MajorProject.model.Booking;
import com.example.MajorProject.model.Cab;
import com.example.MajorProject.model.Customer;
import com.example.MajorProject.model.Driver;

public class BookingTransformer {


    public static Booking BookingRequestToBooking(BookingRequest bookingRequest, double per_km_rate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .trip_distance_in_Km(bookingRequest.getTrip_distance_in_Km())
                .trip_status(TripStatus.BOOKED)
                .bill_amount(bookingRequest.getTrip_distance_in_Km()*per_km_rate)
                .build();
    }


    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer, Driver driver, Cab cab){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .trip_distance_in_Km(booking.getTrip_distance_in_Km())
                .trip_status(booking.getTrip_status())
                .bill_amount(booking.getBill_amount())
                .bookedAt(booking.getBookedAt())
                .lastUpdateAt(booking.getLastUpdateAt())
                .customer(CustomerTransformer.customerToCustomerResponse(customer))
                .cab(CabTransformer.cabToCabResponse(cab,driver))
                .build();
    }
}
