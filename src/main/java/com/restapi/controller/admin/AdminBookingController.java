package com.restapi.controller.admin;

import com.restapi.model.CarReservation;
import com.restapi.response.common.APIResponse;
import com.restapi.response.user.BookingResponse;
import com.restapi.service.admin.AdminBookingService;
import com.restapi.service.admin.AdminCarService;
import com.restapi.service.user.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/booking")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminBookingController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private AdminBookingService adminBookingService;

    @GetMapping("/upcommingreservation")
    public ResponseEntity<APIResponse> getAllCurrentReservation(){
        List<BookingResponse> upcommingReservation= adminBookingService.findAllUpcommingReservation();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(upcommingReservation);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
