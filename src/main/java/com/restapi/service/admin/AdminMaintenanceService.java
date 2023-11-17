package com.restapi.service.admin;

import com.restapi.model.MaintenanceSchedule;
import com.restapi.repository.MaintenanceScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminMaintenanceService {
    @Autowired
    private MaintenanceScheduleRepository maintenanceScheduleRepository;


    public List<MaintenanceSchedule> findAllCurrentMonthMaintenance() {
        return maintenanceScheduleRepository.findByCurrentMonth();
    }
}
