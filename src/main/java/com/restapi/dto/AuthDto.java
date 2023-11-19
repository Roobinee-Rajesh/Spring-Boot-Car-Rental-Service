package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.request.RegisterRequest;
import com.restapi.request.user.UserRequest;
import com.restapi.response.AuthResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthDto {

    public AppUser mapToAppUser(RegisterRequest user) {
        AppUser appUser = new AppUser();
        if (user.getId() != null) {
            appUser.setId(user.getId());
        }
        appUser.setUsername(user.getUsername());
        appUser.setName(user.getName());
        appUser.setPassword(user.getPassword());
        appUser.setEmail(user.getEmail());
        appUser.setPhone_number(user.getPhone_number());
        appUser.setAddress(user.getAddress());
        return appUser;
    }


    public AuthResponse mapToAuthResponse(AppUser appUser) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(appUser.getId());
        authResponse.setName(appUser.getName());
        authResponse.setUsername(appUser.getUsername());
        authResponse.setEmail(appUser.getEmail());
        authResponse.setPhone_number(appUser.getPhone_number());
        authResponse.setAddress(appUser.getAddress());
        authResponse.setRole(appUser.getRoles().getName());
        return authResponse;
    }


}
