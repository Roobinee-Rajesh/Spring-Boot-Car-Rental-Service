package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.lang.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "users") // don't use User
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 13)
    private String phone_number;

    @Column(nullable = false, length = 100)
    private String address;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role roles;

    @OneToMany(mappedBy = "appUser")
    private List<CarReservation> carReservations;

    @OneToMany(mappedBy = "appUser")
    private List<MaintenanceSchedule> maintenanceSchedulesUser;

    @OneToMany(mappedBy = "maintenanceStaff")
    private List<CarDetail> carDetails;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

}
