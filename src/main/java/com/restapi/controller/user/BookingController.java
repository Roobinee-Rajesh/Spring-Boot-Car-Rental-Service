package com.restapi.controller.user;

import com.restapi.dto.user.BookingDto;
import com.restapi.model.CarDetail;
import com.restapi.model.CarReservation;
import com.restapi.response.common.APIResponse;
import com.restapi.service.user.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/booking")
@PreAuthorize("hasRole('ROLE_USER')")
public class BookingController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private BookingService bookingService;
    @GetMapping("/futurereservation/{userId}")
    public ResponseEntity<APIResponse> getAllFutureReservation(@PathVariable Integer userId){
        List<CarReservation> userReservationList= bookingService.findAllFutureReservationOfUser(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userReservationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reservationId}/{userId}")
    public ResponseEntity<APIResponse> deleteCar(@PathVariable Integer reservationId,@PathVariable Integer userId) {
        List<CarReservation> userReservationList = bookingService.deleteById(reservationId,userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userReservationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/pastreservation/{userId}")
    public ResponseEntity<APIResponse> getAllPastReservation(@PathVariable Integer userId){
        List<CarReservation> userReservationList= bookingService.findAllPastReservationOfUser(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userReservationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/currentreservation/{userId}")
    public ResponseEntity<APIResponse> getAllCurrentReservation(@PathVariable Integer userId){
        List<CarReservation> userReservationList= bookingService.findAllCurrentReservationOfUser(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userReservationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
