package com.restapi.service.user;

import com.restapi.dto.user.BookingDto;
import com.restapi.model.CarReservation;
import com.restapi.repository.CarReservationRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingDto bookingDto;
    @Autowired
    CarReservationRepository carReservationRepository;

    public List<CarReservation> findAllFutureReservationOfUser(Integer userId) {
        LocalDateTime currentDate = LocalDateTime.now();
        return carReservationRepository.findAllUpcomingReservationsOfUser(userId, currentDate);
    }

    public List<CarReservation> deleteById(Integer reservationId,Integer userId) {
        carReservationRepository.deleteById(reservationId);
        return findAllFutureReservationOfUser(userId);
    }

    public List<CarReservation> findAllPastReservationOfUser(Integer userId) {
        LocalDateTime currentDate = LocalDateTime.now();
        return carReservationRepository.findAllPastReservationsOfUser(userId, currentDate);
    }


    public List<CarReservation> findAllCurrentReservationOfUser(Integer userId) {
        LocalDateTime currentDate = LocalDateTime.now();
        return carReservationRepository.findAllCurrentReservationsOfUser(userId,currentDate);
    }
}
