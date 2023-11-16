package com.restapi.repository;

import com.restapi.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Integer> {
    Optional<CarStatus> findByStatus(String status);
}
