package com.usstudy.interviewproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegistrationRequest {
    private int employeeNumber;
    private String employeeName;
    private String phone;
    private String position;
    private String email;
}
