package com.restapi.service;

import com.restapi.dto.AuthDto;
import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.repository.RoleRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    private AuthDto authDto;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthResponse registerStaff(RegisterRequest registerRequest) {
        AppUser appUser = authDto.mapToAppUser(registerRequest);
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setRoles(roleRepository.findByName(Role.STAFF));
        appUser = userRepository.save(appUser);
        return authDto.mapToAuthResponse(appUser);
    }

}
