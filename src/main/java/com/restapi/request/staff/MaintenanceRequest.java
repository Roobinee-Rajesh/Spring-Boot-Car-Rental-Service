package com.restapi.request.staff;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
@Component
@Getter
@Setter
public class MaintenanceRequest {
    private Integer id;
    private Date maintenanceDate;
    private Integer statusId;
    private Integer userId;
    private Integer carDetailId;
}
