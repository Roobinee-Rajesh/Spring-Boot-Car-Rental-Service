package com.restapi.controller.admin;

import com.restapi.dto.admin.AdminCarDto;
import com.restapi.model.AppUser;
import com.restapi.model.CarDetail;
import com.restapi.request.admin.AdminCarRequest;
import com.restapi.request.admin.AdminStaffRequest;
import com.restapi.request.user.CarRequest;
import com.restapi.response.admin.AdminCarResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.StorageService;
import com.restapi.service.admin.AdminCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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

    @Autowired
    private StorageService storageService;

    @GetMapping("/viewCars")
    public ResponseEntity<APIResponse> getAllCar(){
        List<AdminCarResponse> carList= adminCarService.findAllCars();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(carList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @PostMapping("/addCar")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> addCar(
                                              @RequestParam("photo") MultipartFile photo,
                                              @RequestParam("manufacturer") String manufacturer,
                                              @RequestParam("model") String model,
                                              @RequestParam("year") int year,
                                              @RequestParam("seats") int seats,
                                              @RequestParam("rental_pricing") int rental_pricing,
                                              @RequestParam("maintenance_schedule") int maintenance_schedule,
                                              @RequestParam("maintenance_staff_id") String maintenance_staff_id
                                            )throws IOException {
//        System.out.println("Photo: " + photo.getOriginalFilename());
//        System.out.println("manufacturer: " + manufacturer);
//        System.out.println("model : " + model);
//        System.out.println("seats: " + seats);
//        System.out.println("rental_pricing: " + rental_pricing);
//        System.out.println("maintenance_schedule: " + maintenance_schedule);
//        System.out.println("maintenance_staff_id: " + maintenance_staff_id);


        String file = storageService.storeFile(photo);
        AdminCarRequest adminCarRequest = new AdminCarRequest();
        adminCarRequest.setPhoto(file);
        adminCarRequest.setManufacturer(manufacturer);
        adminCarRequest.setModel(model);
        adminCarRequest.setYear(year);
        adminCarRequest.setSeats(seats);
        adminCarRequest.setRental_pricing(rental_pricing);
        adminCarRequest.setMaintenance_staff_id(maintenance_staff_id);
        adminCarRequest.setMaintenance_schedule(maintenance_schedule);

        CarDetail carDetail = adminCarService.addCar(adminCarRequest);
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
        List<AdminCarResponse> carList = adminCarService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(carList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
