package com.restapi.dto;

import com.restapi.model.CarDetail;
import com.restapi.model.CarReservation;
import com.restapi.response.user.CarResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDto {
    public List<CarResponse> mapToCarResponse(List<CarDetail> carDetail) {
        List<CarResponse> carResponseList = new ArrayList<>();
        for (CarDetail c : carDetail) {
            CarResponse carRespose = new CarResponse();
            carRespose.setId(c.getId());
            carRespose.setManufacturer(c.getManufacturer());
            carRespose.setModel(c.getModel());
            carRespose.setYear(c.getYear());
            carRespose.setSeats(c.getSeats());
            carRespose.setRental_pricing(c.getRental_pricing());
            carRespose.setPhoto(c.getPhoto());

            carResponseList.add(carRespose);
        }
        return carResponseList;
    }
}
