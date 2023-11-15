package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterRequest {

    @NotEmpty
    @Size(min = 2, message = "Username should have at least 2 characters")
    private String username;

    @NotEmpty
    @Size(min = 2, message = "Password should have at least 2 characters")
    private String password;

    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Phone number cannot be empty")
    private Integer phone_number;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

}
