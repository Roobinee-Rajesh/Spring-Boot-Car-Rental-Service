package com.restapi.controller.Admin;

import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/admin")
public class AdminStaffController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserService userService;
    @PostMapping("/registerStaff")
    public ResponseEntity<APIResponse> registerStaff(@Valid @RequestBody RegisterRequest registerRequest) {
        AuthResponse registeredUser = userService.register(registerRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(registeredUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
