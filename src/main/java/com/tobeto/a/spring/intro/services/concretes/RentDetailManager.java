package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.Employee;
import com.tobeto.a.spring.intro.entities.RentDetail;
import com.tobeto.a.spring.intro.repositories.RentDetailRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.abstracts.EmployeeService;
import com.tobeto.a.spring.intro.services.abstracts.RentDetailService;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.AddRentDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.DeleteRentDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.UpdateRentDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.responses.GetListRentDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RentDetailManager implements RentDetailService {
    private final RentDetailRepository rentDetailRepository;
    private  final CustomerService customerService;
    private final CarService carService;
    private final EmployeeService employeeService;

    @Override
    public List<RentDetail> getByName(String name) {
        return rentDetailRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetListRentDetailResponse> getByNameDto(String name) {
        return rentDetailRepository.findByNameDto(name);
    }

    @Override
    public void add(AddRentDetailRequest request) {
        RentDetail rentDetail = new RentDetail();
        rentDetail.setTotalRentDay(request.getTotalRentDay());
        rentDetail.setRentStartDate(request.getRentStartDate());
        rentDetail.setRentEndDate(request.getRentEndDate());
        Customer customer = customerService.getById(request.getId());
        rentDetail.setCustomer(customer);
        Car car = carService.getById(request.getId());
        rentDetail.setCar(car);
        Employee employee = employeeService.getById(request.getId());
        rentDetail.setEmployee(employee);
        rentDetailRepository.save(rentDetail);

    }

    @Override
    public void update(UpdateRentDetailRequest request) {
        RentDetail rentDetailToUpdate = rentDetailRepository.findById(request.getId()).orElseThrow();
        rentDetailToUpdate.setTotalRentDay(request.getTotalRentDay());
        rentDetailToUpdate.setRentStartDate(request.getRentStartDate());
        rentDetailToUpdate.setRentEndDate(request.getRentEndDate());
        Customer customer = customerService.getById(request.getId());
        rentDetailToUpdate.setCustomer(customer);
        Car car = carService.getById(request.getId());
        rentDetailToUpdate.setCar(car);
        Employee employee = employeeService.getById(request.getId());
        rentDetailToUpdate.setEmployee(employee);
        rentDetailRepository.save(rentDetailToUpdate);

    }

    @Override
    public void delete(DeleteRentDetailRequest request) {
        RentDetail rentDetailToDelete = rentDetailRepository.findById(request.getId()).orElseThrow();
        rentDetailRepository.delete(rentDetailToDelete);
    }
}
