package com.usstudy.interviewproject.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSearchRequest {
    private int employeeNumber;
    private String employeeName;
    private String phone;
    private String position;
    private String email;
}
