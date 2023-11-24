package com.restapi.service.admin;

import com.restapi.dto.admin.AdminCarDto;
import com.restapi.model.AppUser;
import com.restapi.model.CarDetail;
import com.restapi.model.Role;
import com.restapi.repository.CarDetailRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.admin.AdminCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class AdminCarService {
    @Autowired
    private AdminCarDto adminCarDto;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarDetailRepository carDetailRepository;

    @Transactional
    public CarDetail addCar(AdminCarRequest carRequest) {
        CarDetail carDetail = adminCarDto.mapToCarDetail(carRequest);
        Optional<AppUser> appUser = userRepository.findById(Integer.valueOf(carRequest.getMaintenance_staff_id()));
        carDetail.setMaintenanceStaff(appUser.orElseThrow(() -> new RuntimeException("Maintenance staff not found")));
        carDetailRepository.save(carDetail);
        return carDetail;
    }

    public List<CarDetail> findAllCars() {
        return carDetailRepository.findAll();
    }

    public List<CarDetail> deleteById(Integer id) {
        carDetailRepository.deleteById(id);
        return findAllCars();
    }

    @Transactional
    public CarDetail updateCar(AdminCarRequest adminCarRequest) {
        CarDetail carDetail = adminCarDto.mapToCarDetails(adminCarRequest);
        AppUser maintenanceStaff = userRepository.findById(Integer.valueOf(adminCarRequest.getMaintenance_staff_id()))
                .orElseThrow(() -> new RuntimeException("Maintenance staff not found"));
        carDetail.setMaintenanceStaff(maintenanceStaff);
        carDetail = carDetailRepository.save(carDetail);
        return carDetail;

    }
}
