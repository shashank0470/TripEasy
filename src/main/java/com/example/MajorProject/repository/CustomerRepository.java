package com.example.MajorProject.repository;

import com.example.MajorProject.Dto.response.CustomerResponse;
import com.example.MajorProject.Enum.Gender;
import com.example.MajorProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByGender(Gender gender);
    List<Customer> findByGenderAndAge(Gender gender, int age);
}
