package com.restapi.service.user;

import com.restapi.dto.CarDto;
import com.restapi.model.CarDetail;
import com.restapi.repository.CarDetailRepository;
import com.restapi.request.user.CarRequest;
import com.restapi.response.user.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarDto carDto;
    @Autowired
    private CarDetailRepository carDetailRepository;
    public List<CarDetail> findAllACars() {
        return carDetailRepository.findAll();
    }

    public Optional<CarDetail> findCarById(Integer carId) {
        return carDetailRepository.findById(carId);
    }


    public List<CarResponse> findAllAvailableCars(String start_date, String end_date) throws ParseException {
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdate.parse(start_date);
        Date endDate = sdate.parse( end_date);
//        return carDetailRepository.findByAvailablity(startDate,endDate);
        List<CarDetail> carDetails=carDetailRepository.findByAvailablity(startDate,endDate);
        return carDto.mapToCarResponse(carDetails);
    }
}
