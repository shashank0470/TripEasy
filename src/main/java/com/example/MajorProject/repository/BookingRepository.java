package com.example.MajorProject.repository;


import com.example.MajorProject.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Modifying
    @Transactional
    @Query(value = "delete from booking where customer_id = :customerId", nativeQuery = true)
    void deleteBookingsByCustomerId(@Param("customerId") int customerId);
}
