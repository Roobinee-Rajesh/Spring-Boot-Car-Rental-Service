package com.restapi.response.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AdminCarResponse {
    private Integer id;
    private String manufacture;
    private String model;
    private int year;
    private int seats;
    private double rental_pricing;
    private byte[] photo;
    private Integer maintenance_staff_id;
    private int maintenance_schedule;
}
