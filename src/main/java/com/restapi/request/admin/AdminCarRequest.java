package com.restapi.request.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Component
@Getter
@Setter
public class AdminCarRequest {

    private Integer id;

    @NotEmpty(message = "Manufacture can't be empty")
    @Size(min = 3, message = "Manufacture should have at least 3 characters")
    private String manufacturer;

    @NotEmpty(message = "Model can't be empty")
    @Size(min = 3, message = "Model should have at least 3 characters")
    private String model;

    @NotNull(message = "Year can't be empty")
    private int year;

    @NotNull(message = "Seats can't be empty")
    private int seats;

    @NotNull(message = "Rental proce can't be empty")
    private int rental_pricing;



    @NotNull(message = "Maintenance Schedule can't be empty")
    private int maintenance_schedule;

//    @NotNull(message = "Photo can't be empty")
    private String photo;

    @NotNull(message = "Staff can't be empty")
    private String maintenance_staff_id;

}
