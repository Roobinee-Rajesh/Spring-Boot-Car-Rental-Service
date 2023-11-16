package com.restapi.request.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
@Getter
@Setter
public class AdminCarRequest {

    private Integer id;

    @NotEmpty
    @Size(min = 3, message = "Manufacture should have at least 3 characters")
    private String manufacture;

    @NotEmpty
    @Size(min = 3, message = "Manufacture should have at least 3 characters")
    private String model;

    @NotNull
    private int year;

    @NotNull
    private int seats;

    @NotNull
    private double rental_pricing;


    @NotNull
    private int maintenance_schedule;

    private byte[] photo;

    private Integer maintenance_staff_id;

}
