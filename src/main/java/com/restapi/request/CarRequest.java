package com.restapi.request;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class CarRequest {

    @NotEmpty
    @Size(min = 3, message = "Manufacture should have at least 3 characters")
    private String manufacture;

    @NotEmpty
    @Size(min = 3, message = "Manufacture should have at least 3 characters")
    private String model;

    @NotEmpty
    private int year;

    @NotEmpty
    private int seats;

    @NotEmpty
    private double rental_pricing;

    @NotEmpty
    private LocalDateTime maintenance_schedule;

    @NotEmpty
    private String maintenance_staff;

    @NotEmpty
    private byte[] photo;

    private Boolean is_booked;

}
