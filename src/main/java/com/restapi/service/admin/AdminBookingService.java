package com.restapi.service.admin;

import com.restapi.model.CarReservation;
import com.restapi.repository.CarReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class AdminBookingService {
    @Autowired
    private CarReservationRepository carReservationRepository;

    public List<CarReservation> findAllUpcommingReservation() {
        LocalDateTime currentDate = LocalDateTime.now();
        return carReservationRepository.findAllUpcommingReservation(currentDate);
    }
}
