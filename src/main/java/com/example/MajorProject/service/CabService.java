package com.example.MajorProject.service;

import com.example.MajorProject.Dto.request.CabRequest;
import com.example.MajorProject.Dto.response.CabResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabService {

    @Autowired
    CabRepository cabRepository;

    public CabResponse registerCab(CabRequest cabRequest, int driverId) {

    }
}
