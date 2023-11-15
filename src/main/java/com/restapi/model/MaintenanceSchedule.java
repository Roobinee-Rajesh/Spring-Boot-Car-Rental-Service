package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MaintenanceSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String maintenance_staff;

    @Column(nullable = false)
    private LocalDateTime maintenance_date;

    @OneToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private MaintenanceSchedule maintenanceStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "car_detail_id", referencedColumnName = "id")
    private CarDetail carDetail;

}
