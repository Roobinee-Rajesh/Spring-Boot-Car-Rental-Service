package com.restapi.service.user;

import com.restapi.dto.CarDto;
import com.restapi.model.CarDetail;
import com.restapi.repository.CarDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
