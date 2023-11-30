package com.restapi.service.admin;

import com.restapi.dto.user.BookingDto;
import com.restapi.model.CarReservation;
import com.restapi.repository.CarReservationRepository;
import com.restapi.response.user.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service

public class AdminBookingService {
    @Autowired
    private CarReservationRepository carReservationRepository;
    @Autowired
    private BookingDto bookingDto;

    public List<BookingResponse> findAllUpcommingReservation() {
//        LocalDateTime currentDate = LocalDateTime.now();
        Date currentDateAsDate=getCurrentDate();
//        return carReservationRepository.findAllUpcommingReservation(currentDateAsDate);
        List<CarReservation> carReservation = carReservationRepository.findAllUpcommingReservation(currentDateAsDate);
        return bookingDto.mapToBookingResponse(carReservation);
    }

    public Date getCurrentDate() {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = currentDate.format(formatter);
        Date currentDateAsDate = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());
        return currentDateAsDate;
    }
}
