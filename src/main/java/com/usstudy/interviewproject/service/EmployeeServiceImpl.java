package com.usstudy.interviewproject.service;

import com.usstudy.interviewproject.domain.dto.request.EmployeeRegistrationRequest;
import com.usstudy.interviewproject.domain.dto.request.EmployeeSearchRequest;
import com.usstudy.interviewproject.domain.entity.Employee;
import com.usstudy.interviewproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployee{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void registedEmployee(EmployeeRegistrationRequest request) {
        Employee newEmployee = new Employee();

        newEmployee.setEmployeeId(0);
        newEmployee.setEmployeeNumber(request.getEmployeeNumber());
        newEmployee.setEmployeeName(request.getEmployeeName());
        newEmployee.setPhone(request.getPhone());
        newEmployee.setPosition(request.getPosition());
        newEmployee.setEmail(request.getEmail());

        employeeRepository.save(newEmployee);
    }

    @Override
    public List<Employee> getByNameOrder() {
        return employeeRepository.getByNameOrder();
    }

    @Override
    public void updateEmployee(EmployeeRegistrationRequest request, Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Employee not found - " + id));

        employee.setEmployeeName(request.getEmployeeName());
        employee.setEmployeeNumber(request.getEmployeeNumber());
        employee.setPosition(request.getPosition());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());

        employeeRepository.save(employee);
    }

    @Override
    public void removeEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Employee not found - " + id));

        employeeRepository.delete(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NullPointerException("Employee not found - " + id));
    }

    @Override
    public List<Employee> getEmployeeByOrder(EmployeeSearchRequest request) {
        return employeeRepository.filterEmployee(request);
    }
}
