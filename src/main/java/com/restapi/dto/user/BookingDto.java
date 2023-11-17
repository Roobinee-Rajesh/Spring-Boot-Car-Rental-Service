package com.restapi.dto.user;

import com.restapi.model.AppUser;
import com.restapi.model.CarDetail;
import com.restapi.model.CarReservation;
import com.restapi.repository.CarDetailRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.user.CarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Component
public class BookingDto {
    @Autowired
    private CarDetailRepository carDetailRepository;
    @Autowired
    private UserRepository userRepository;


    public CarReservation mapToCarReservation(Integer carId, Integer userId, CarRequest carRequest) {
        CarReservation carReservation = new CarReservation();
        Optional<CarDetail> carDetail=carDetailRepository.findById(carId);
        Optional<AppUser> appUser=userRepository.findById(userId);
//        System.out.println("before date");
        int total_price;
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdate.parse(carRequest.getStart_date());
            Date endDate = sdate.parse(carRequest.getEnd_date());
            Duration duration = Duration.between(startDate.toInstant(), endDate.toInstant());
            long days = duration.toDays();
            total_price= (int) (days*(carDetail.get().getRental_pricing()));
            carReservation.setStart_date(startDate);
            carReservation.setEnd_date(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("after date");

        carReservation.setTotal_price(total_price);
        carReservation.setCarDetail(carDetail.get());
        carReservation.setAppUser(appUser.get());


        return carReservation;

    }
}
