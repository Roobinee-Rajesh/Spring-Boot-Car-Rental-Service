package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String manufacture;

    @Column(nullable = false, length = 200)
    private String model;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false)
    private double rental_pricing;

    @Column(nullable = false)
    private LocalDateTime maintenance_schedule;

    @Column(nullable = false)
    private String maintenance_staff;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

    private Boolean delete_flag = false;

    private Boolean is_booked = false;

    @OneToMany(mappedBy = "carDetail")
    private List<CarReservation> carReservations;

    @OneToMany(mappedBy = "carDetail")
    private List<MaintenanceSchedule> maintenanceSchedulesCar;
}
