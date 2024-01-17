package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.core.utilities.mappers.ModelMapperService;
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

    private final ModelMapperService modelMapperService;


    @Override
    public List<RentDetail> getAll() {
        return rentDetailRepository.findAll();
    }

    @Override
    public void add(AddRentDetailRequest request) {
        RentDetail rentDetail = this.modelMapperService.forRequest().map(request,RentDetail.class);

        rentDetailRepository.save(rentDetail);

    }

    @Override
    public void update(UpdateRentDetailRequest request) {
        RentDetail rentDetailToUpdate = this.modelMapperService.forRequest().map(request,RentDetail.class);
        rentDetailRepository.save(rentDetailToUpdate);

    }

    @Override
    public void delete(DeleteRentDetailRequest request) {
        RentDetail rentDetailToDelete = rentDetailRepository.findById(request.getId()).orElseThrow();
        rentDetailRepository.delete(rentDetailToDelete);
    }
}
