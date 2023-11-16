package com.restapi.controller.admin;

import com.restapi.dto.admin.AdminCarDto;
import com.restapi.model.AppUser;
import com.restapi.model.CarDetail;
import com.restapi.request.admin.AdminCarRequest;
import com.restapi.request.admin.AdminStaffRequest;
import com.restapi.response.admin.AdminCarResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.admin.AdminCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/car")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminCarController {

    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private AdminCarService adminCarService;
    @Autowired
    private AdminCarResponse adminCarResponse;
    @Autowired
    private AdminCarDto adminCarDto;

    @GetMapping("/viewCars")
    public ResponseEntity<APIResponse> getAllCar(){
        List<CarDetail> carList= adminCarService.findAllCars();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(carList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/addCar")
    public ResponseEntity<APIResponse> addCar(@Valid @RequestBody AdminCarRequest carRequest) {
        CarDetail carDetail = adminCarService.addCar(carRequest);
        AdminCarResponse adminCarResponse=adminCarDto.mapToCarResponse(carDetail);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(adminCarResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/updateCar")
    public ResponseEntity<APIResponse> updateStaff(@RequestBody AdminCarRequest adminCarRequest){
        CarDetail updateCar=adminCarService.updateCar(adminCarRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updateCar);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteCar(@PathVariable Integer id) {
        List<CarDetail> carList = adminCarService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(carList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
