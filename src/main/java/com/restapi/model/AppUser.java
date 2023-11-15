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
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    @NotEmpty
    @Size(min = 2, message = "Username should have at least 2 characters")
    private String username;

    @Column(nullable = false, length = 100)
    @NotEmpty
    @Size(min = 2, message = "Password should have at least 2 characters")
    private String password;

    @Column(nullable = false, length = 100)
    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false, length = 10)
    @NotNull(message = "Phone number cannot be null")
    private Integer phone_number;

    @Column(nullable = false, length = 100)
    @NotEmpty
    private String address;

    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role roles;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Boolean delete_flag = false;

    @OneToMany(mappedBy = "appUser")
    private List<CarReservation> carReservations;

    @OneToMany(mappedBy = "appUser")
    private List<MaintenanceSchedule> maintenanceSchedulesUser;

}
