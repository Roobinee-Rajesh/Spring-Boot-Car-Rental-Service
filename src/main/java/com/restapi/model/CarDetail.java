package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;

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
    private int maintenance_schedule;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "maintenance_staff_id", referencedColumnName = "id")
    private AppUser maintenanceStaff;

    @Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private byte[] photo;

    @JsonIgnore
    @OneToMany(mappedBy = "carDetail")
    private List<CarReservation> carReservations;

    @JsonIgnore
    @OneToMany(mappedBy = "carDetail")
    private List<MaintenanceSchedule> maintenanceSchedulesCar;
}
