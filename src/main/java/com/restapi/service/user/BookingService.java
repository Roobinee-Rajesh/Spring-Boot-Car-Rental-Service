package com.restapi.service.user;

import com.restapi.dto.user.BookingDto;
import com.restapi.model.AppUser;
import com.restapi.model.CarDetail;
import com.restapi.model.CarReservation;
import com.restapi.repository.CarDetailRepository;
import com.restapi.repository.CarReservationRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.user.CarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingDto bookingDto;
    @Autowired
    CarReservationRepository carReservationRepository;
    @Autowired
    CarDetailRepository carDetailRepository;

    @Autowired
    UserRepository userRepository;

    public List<CarReservation> findAllFutureReservationOfUser(Integer userId) {
        LocalDateTime currentDate = LocalDateTime.now();
        return carReservationRepository.findAllUpcomingReservationsOfUser(userId, currentDate);
    }

    public List<CarReservation> deleteById(Integer reservationId, Integer userId) {
        carReservationRepository.deleteById(reservationId);
        return findAllFutureReservationOfUser(userId);
    }

    public List<CarReservation> findAllPastReservationOfUser(Integer userId) {
        LocalDateTime currentDate = LocalDateTime.now();
        return carReservationRepository.findAllPastReservationsOfUser(userId, currentDate);
    }


    public List<CarReservation> findAllCurrentReservationOfUser(Integer userId) {
        LocalDateTime currentDate = LocalDateTime.now();
        return carReservationRepository.findAllCurrentReservationsOfUser(userId, currentDate);
    }

    @Transactional
    public List<CarReservation> bookCar(Integer carId, CarRequest carRequest, Integer userId) {
        CarReservation carReservation = bookingDto.mapToCarReservation(carId, userId, carRequest);
        carReservationRepository.save(carReservation);
        return carReservationRepository.findAll();
    }
}
