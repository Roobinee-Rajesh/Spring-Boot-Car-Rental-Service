package com.restapi.response;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class CarResponse {
    private Long id;
    private String manufacture;
    private String model;
    private int year;
    private int seats;
    private double rental_pricing;
    private LocalDateTime maintenance_schedule;
    private String maintenance_staff;
    private byte[] photo;
    private Boolean is_booked;
}

