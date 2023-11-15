package com.restapi.controller.User;

import com.restapi.model.CarDetail;
import com.restapi.request.CarRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user/car")
public class CarController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private CarService carService;

    @GetMapping("/allavailableCars")
    public ResponseEntity<APIResponse> getAvailableCars() {
        List<CarDetail> availableCarList = carService.findAllAvailableCars();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(availableCarList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
