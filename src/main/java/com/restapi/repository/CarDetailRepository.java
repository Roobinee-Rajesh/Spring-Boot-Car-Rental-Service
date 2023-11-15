package com.restapi.repository;

import com.restapi.model.CarDetail;
import com.restapi.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Long> {
    @Query("SELECT c FROM CarDetail c WHERE c.is_booked = false")
    List<CarDetail> findAllAvailableCar();
}
