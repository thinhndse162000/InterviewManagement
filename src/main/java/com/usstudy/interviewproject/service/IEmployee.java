package com.usstudy.interviewproject.service;


import com.usstudy.interviewproject.domain.dto.request.EmployeeRegistrationRequest;
import com.usstudy.interviewproject.domain.dto.request.EmployeeSearchRequest;
import com.usstudy.interviewproject.domain.entity.Employee;

import java.util.List;

public interface IEmployee {
    void registedEmployee(EmployeeRegistrationRequest request);

    List<Employee> getByNameOrder();

    void updateEmployee(EmployeeRegistrationRequest request, Integer id);

    void removeEmployee(Integer id);

    Employee getById(Integer id);

    List<Employee> getEmployeeByOrder(EmployeeSearchRequest request);
}
