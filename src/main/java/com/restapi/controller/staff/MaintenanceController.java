package com.restapi.controller.staff;

import com.restapi.model.CarReservation;
import com.restapi.model.MaintenanceSchedule;
import com.restapi.request.staff.MaintenanceRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.response.staff.MaintenanceResponse;
import com.restapi.service.staff.MaintenanceService;
import com.restapi.service.user.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@PreAuthorize("hasRole('ROLE_STAFF')")
public class MaintenanceController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping("/viewMaintenance/{staffId}")
    public ResponseEntity<APIResponse> getStaffMaintenance(@PathVariable Integer staffId){
        List<MaintenanceResponse> staffMaintenanceSchudeleList= maintenanceService.findMaintenanceByStaff(staffId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(staffMaintenanceSchudeleList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/UpdateStatus")
    public ResponseEntity<APIResponse> updateMaintenanceStatus(@RequestBody MaintenanceRequest maintenanceRequest){
        List<MaintenanceSchedule> updatedMaintenanceSchudeleList= maintenanceService.updateMaintenanceStaff(maintenanceRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updatedMaintenanceSchudeleList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
