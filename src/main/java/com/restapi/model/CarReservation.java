package com.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime reservation_date;

    @Column(nullable = false)
    private LocalDateTime start_date;

    @Column(nullable = false)
    private LocalDateTime end_date;

    @Column(nullable = false)
    private double total_price;

    @OneToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private CarStatus carStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private CarDetail carDetail;


}
