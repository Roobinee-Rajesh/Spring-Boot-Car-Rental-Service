package com.restapi.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private Long id;
    private String username;
    private String name;
    private String email;
    private Integer phone_number;
    private String address;
}
