package com.restapi.repository;

import com.restapi.model.MaintenanceSchedule;
import com.restapi.model.MaintenanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaintenanceStatusRepository extends JpaRepository<MaintenanceStatus, Long> {
    Optional<MaintenanceStatus> findByStatus(String status);
}
