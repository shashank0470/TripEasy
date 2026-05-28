package com.example.MajorProject.repository;

import com.example.MajorProject.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query(value = "select * from driver d where d.cab_id = :cabId", nativeQuery = true)
    Driver getDriverByCabId(@Param("cabId") int cabId);
}
