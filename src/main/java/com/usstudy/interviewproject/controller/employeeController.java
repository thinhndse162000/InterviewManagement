package com.usstudy.interviewproject.controller;

import com.usstudy.interviewproject.domain.dto.request.EmployeeRegistrationRequest;
import com.usstudy.interviewproject.domain.dto.request.EmployeeSearchRequest;
import com.usstudy.interviewproject.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.usstudy.interviewproject.service.IEmployee;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class employeeController {
    private final IEmployee serivce;

    @Autowired
    public employeeController(IEmployee serivce) {
        this.serivce = serivce;
    }
    @GetMapping("/")
    String index(Model model) {
        List<Employee> employeeList = serivce.getByNameOrder();
        model.addAttribute("request", new Employee());
        model.addAttribute("employee",employeeList);
        model.addAttribute("search", new EmployeeSearchRequest());
        return "index";
    }
    @PostMapping("/search")
    public String searchByRequest(@ModelAttribute("search") EmployeeSearchRequest request, Model model){
        List<Employee> employeeList = serivce.getEmployeeByOrder(request);
        model.addAttribute("search", request);
        model.addAttribute("request", new Employee());
        model.addAttribute("employee", employeeList);
        return "index";
    }
    @PostMapping("/submit")
    public String RegistedEmployee(@ModelAttribute("request") EmployeeRegistrationRequest request, Model model){
        serivce.registedEmployee(request);
        List<Employee> employeeList = serivce.getByNameOrder();
        model.addAttribute("request", new Employee());
        model.addAttribute("employee",employeeList);
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showPageEdit(@PathVariable Integer id, Model model){
        Employee employee = serivce.getById(id);
        model.addAttribute("employeeDTO", employee);
        return "edit" ;
    }
}
