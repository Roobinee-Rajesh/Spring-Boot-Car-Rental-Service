package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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
    private String manufacturer;

    @Column(nullable = false, length = 200)
    private String model;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false)
    private int rental_pricing;

    @Column(nullable = false)
    private int maintenance_schedule;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "maintenance_staff_id", referencedColumnName = "id")
    private AppUser maintenanceStaff;

    @Column(name = "photo")
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "carDetail")
    private List<CarReservation> carReservations;

    @JsonIgnore
    @OneToMany(mappedBy = "carDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceSchedule> maintenanceSchedules;

}
