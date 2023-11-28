package com.restapi.controller.admin;

import com.restapi.model.AppUser;
import com.restapi.request.RegisterRequest;
import com.restapi.request.admin.AdminStaffRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.admin.AdminStaffResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.admin.AdminStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/staff")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminStaffController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private AdminStaffService staffService;
    @Autowired
    private AdminStaffResponse staffResponse;


    @PostMapping("/registerStaff")
    public ResponseEntity<APIResponse> registerStaff(@Valid @RequestBody RegisterRequest registerRequest) {
        AuthResponse registeredUser = staffService.registerStaff(registerRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(registeredUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/viewStaff")
    public ResponseEntity<APIResponse> getAllStaff(){
        List<AuthResponse> staffList= staffService.findAllStaffMembers();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(staffList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

@Transactional
    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateStaff(@RequestBody AdminStaffRequest adminStaffRequest){
        AppUser updateStaff=staffService.updateStaff(adminStaffRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updateStaff);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteStaff(@PathVariable Integer id) {
        List<AuthResponse> staffList = staffService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(staffList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
