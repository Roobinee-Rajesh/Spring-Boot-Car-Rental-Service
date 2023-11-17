package com.restapi.controller.user;

import com.restapi.model.CarDetail;
import com.restapi.request.user.CarRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.user.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/car")
public class CarController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private CarService carService;

    @Autowired
    private CarRequest carRequest;

    @GetMapping("/allCars")
    public ResponseEntity<APIResponse> getCars() {
        List<CarDetail> allCarList = carService.findAllACars();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(allCarList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/carById/{carId}")
    public ResponseEntity<APIResponse> findCarById(@PathVariable Integer carId) {
        Optional<CarDetail> carDetail = carService.findCarById(carId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(carDetail);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/allAvailableCars")
    public ResponseEntity<APIResponse> getAllAvailableCars(@RequestBody CarRequest carRequest) throws ParseException {
        List<CarDetail> availableCarList = carService.findAllAvailableCars(carRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(availableCarList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
