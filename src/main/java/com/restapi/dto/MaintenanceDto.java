package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.model.CarDetail;
import com.restapi.model.MaintenanceSchedule;
import com.restapi.model.MaintenanceStatus;
import com.restapi.repository.CarDetailRepository;
import com.restapi.repository.MaintenanceStatusRepository;
import com.restapi.repository.UserRepository;
import com.restapi.response.staff.MaintenanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MaintenanceDto {
    @Autowired
    private MaintenanceStatusRepository maintenanceStatusRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarDetailRepository carDetailRepository;
    public List<MaintenanceResponse> mapToMaintenanceResponse(List<MaintenanceSchedule> maintenanceScheduleList) {
        List<MaintenanceResponse> maintenanceResponseList = new ArrayList<>();
        System.out.println("mapToMaintenanceResponse");
        for (MaintenanceSchedule maintenanceSchedule : maintenanceScheduleList) {
            MaintenanceResponse maintenanceResponse = new MaintenanceResponse();
            System.out.println("in");
            maintenanceResponse.setId(maintenanceSchedule.getId());
            maintenanceResponse.setMaintenanceDate(maintenanceSchedule.getMaintenance_date());
            Optional<MaintenanceStatus> maintenanceStatus = maintenanceStatusRepository.findById(maintenanceSchedule.getId());
            maintenanceResponse.setMaintenanceStatus(maintenanceStatus.get().getStatus());
            Optional<AppUser> appUser = userRepository.findById(maintenanceSchedule.getAppUser().getId());
            maintenanceResponse.setUserName(appUser.get().getName());
            Optional<CarDetail> carDetail1 = carDetailRepository.findById(maintenanceSchedule.getCarDetail().getId());
            maintenanceResponse.setCarName(carDetail1.get().getModel());
            maintenanceResponseList.add(maintenanceResponse);
        }
        System.out.println("maintenanceResponseList");
        return maintenanceResponseList;

    }
}
