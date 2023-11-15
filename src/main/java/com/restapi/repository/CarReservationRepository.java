package com.restapi.repository;

import com.restapi.model.CarReservation;
import com.restapi.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarReservationRepository extends JpaRepository<CarReservation, Long> {
}
