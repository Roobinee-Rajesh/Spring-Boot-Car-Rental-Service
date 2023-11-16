package com.restapi.dto;

import com.restapi.model.CarDetail;
import com.restapi.response.user.CarResponse;
import org.springframework.stereotype.Component;

@Component
public class CarDto {
    private CarResponse convertToCarDto(CarDetail carDetail) {
        CarResponse carRespose=new CarResponse();
        carRespose.setId(carDetail.getId());
        carRespose.setManufacture(carDetail.getManufacture());
        carRespose.setModel(carDetail.getModel());
        carRespose.setYear(carDetail.getYear());
        carRespose.setSeats(carDetail.getSeats());
        carRespose.setRental_pricing(carDetail.getRental_pricing());
        carRespose.setPhoto(carDetail.getPhoto());
//        carRespose.setMaintenance_schedule(carDetail.getMaintenanceSchedule());
//        carRespose.setMaintenanceStaff(carDetail.getMaintenanceStaff());
//        carRespose.setIsBooked(carDetail.getIsBooked());
        return carRespose;
    }
}
