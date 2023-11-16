package com.restapi.dto.admin;

import com.restapi.model.CarDetail;
import com.restapi.request.admin.AdminCarRequest;
import com.restapi.response.admin.AdminCarResponse;
import org.springframework.stereotype.Component;

@Component
public class AdminCarDto {
    public CarDetail mapToCarDetail(AdminCarRequest carRequest) {
        CarDetail carDetail = new CarDetail();
        carDetail.setModel(carRequest.getModel());
        carDetail.setManufacture(carRequest.getManufacture());
        carDetail.setYear(carRequest.getYear());
        carDetail.setSeats(carRequest.getSeats());
        carDetail.setRental_pricing(carRequest.getRental_pricing());
        carDetail.setPhoto(carRequest.getPhoto());
        return carDetail;
    }

    public AdminCarResponse mapToCarResponse(CarDetail carDetail){
        AdminCarResponse adminCarResponse=new AdminCarResponse();
        adminCarResponse.setModel(carDetail.getModel());
        adminCarResponse.setManufacture(carDetail.getManufacture());
        adminCarResponse.setYear(carDetail.getYear());
        adminCarResponse.setSeats(carDetail.getSeats());
        adminCarResponse.setRental_pricing(carDetail.getRental_pricing());
        adminCarResponse.setPhoto(carDetail.getPhoto());
        adminCarResponse.setMaintenance_staff_id(carDetail.getMaintenanceStaff().getId());
        return adminCarResponse;
    }

    public CarDetail mapToCarDetails(AdminCarRequest adminCarRequest) {
        CarDetail carDetail=new CarDetail();
        carDetail.setId(adminCarRequest.getId());
        carDetail.setModel(adminCarRequest.getModel());
        carDetail.setManufacture(adminCarRequest.getManufacture());
        carDetail.setYear(adminCarRequest.getYear());
        carDetail.setSeats(adminCarRequest.getSeats());
        carDetail.setRental_pricing(adminCarRequest.getRental_pricing());
        carDetail.setPhoto(adminCarRequest.getPhoto());
        carDetail.setMaintenance_schedule(adminCarRequest.getMaintenance_schedule());
        return carDetail;
    }
}
