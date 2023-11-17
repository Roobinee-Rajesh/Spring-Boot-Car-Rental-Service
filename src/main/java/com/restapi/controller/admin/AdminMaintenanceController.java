package com.restapi.controller.admin;

import com.restapi.model.CarReservation;
import com.restapi.model.MaintenanceSchedule;
import com.restapi.response.common.APIResponse;
import com.restapi.service.admin.AdminBookingService;
import com.restapi.service.admin.AdminMaintenanceService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/maintenance")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminMaintenanceController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private AdminMaintenanceService adminMaintenanceService;

    @GetMapping("/maintenance")
    public ResponseEntity<APIResponse> getAllCurrentMonthMaintenance(){
        List<MaintenanceSchedule> currentMonthMaintenance= adminMaintenanceService.findAllCurrentMonthMaintenance();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(currentMonthMaintenance);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
