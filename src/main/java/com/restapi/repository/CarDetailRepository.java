package com.restapi.repository;

import com.restapi.model.CarDetail;
import com.restapi.request.user.CarRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.validation.Valid;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Integer> {
//    List<CarDetail> findByMaintenance_scheduleGreaterThan(int maintenanceSchedule);
    @Query("SELECT c FROM CarDetail c WHERE c.id = :carId")
    CarDetail findCarById(@Param("carId") Integer carId);
    @Query(value = "SELECT DISTINCT cd.* FROM car_detail cd " +
            "LEFT JOIN car_reservation cr ON cd.id = cr.vehicle_id " +
            "WHERE (cr.start_date IS NULL OR cr.start_date > :end_date OR cr.end_date < :start_date)",
            nativeQuery = true)
    List<CarDetail> findByAvailablity(@Param("start_date") Date startDate, @Param("end_date") Date endDate);
}
