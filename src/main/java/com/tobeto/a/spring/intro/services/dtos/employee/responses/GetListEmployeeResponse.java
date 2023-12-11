package com.tobeto.a.spring.intro.services.dtos.employee.responses;

import com.tobeto.a.spring.intro.services.dtos.address.responses.GetListAddressResponse;
import com.tobeto.a.spring.intro.services.dtos.department.responses.GetListDepartmentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListEmployeeResponse {
    private int id;
    private String name;
    private String surname;
    private int age;
    private GetListAddressResponse address;
    private GetListDepartmentResponse department;
}
