package com.restapi.repository;

import com.restapi.model.CarReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CarReservationRepository extends JpaRepository<CarReservation, Integer> {
    @Query("SELECT c FROM CarReservation c WHERE c.appUser.id = :user_id AND c.start_date > :current_date")
    List<CarReservation> findAllUpcomingReservationsOfUser(@Param("user_id") Integer userId, @Param("current_date") Date currentDate);

    @Query("SELECT c FROM CarReservation c WHERE c.appUser.id = :user_id AND c.end_date < :current_date")
    List<CarReservation> findAllPastReservationsOfUser(@Param("user_id") Integer userId, @Param("current_date") Date currentDate);

    @Query("SELECT c FROM CarReservation c WHERE c.appUser.id = :user_id AND c.start_date <= :current_date AND c.end_date >= :current_date")
    List<CarReservation> findAllCurrentReservationsOfUser(@Param("user_id") Integer userId, @Param("current_date") Date currentDate);
    @Query("SELECT c FROM CarReservation c WHERE c.start_date > :current_date")
    List<CarReservation> findAllUpcommingReservation(@Param("current_date") LocalDateTime currentDate);

}