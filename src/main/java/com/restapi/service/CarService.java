package com.restapi.service;

import com.restapi.dto.CarDto;
import com.restapi.model.CarDetail;
import com.restapi.repository.CarDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    @Autowired
    private CarDto carDto;

    @Autowired
    private CarDetailRepository carDetailRepository;
    public List<CarDetail> findAllAvailableCars() {
        return carDetailRepository.findAllAvailableCar();
    }
}
