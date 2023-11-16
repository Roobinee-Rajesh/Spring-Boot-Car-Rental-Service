package com.restapi.repository;

import com.restapi.model.MaintenanceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceScheduleRepository extends JpaRepository<MaintenanceSchedule,Integer> {
}
