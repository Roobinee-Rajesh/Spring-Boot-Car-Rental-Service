package com.restapi.repository;

import com.restapi.model.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Integer> {

    @Query("SELECT c FROM CarDetail c WHERE c.id = :carId")
    CarDetail findCarById(@Param("carId") Integer carId);
}
