package com.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 200)
    private String status;

    @OneToOne(mappedBy = "maintenanceStatus")
    private MaintenanceSchedule maintenanceSchedule;

    public MaintenanceStatus(String status) {
        this.status = status;
    }
}
