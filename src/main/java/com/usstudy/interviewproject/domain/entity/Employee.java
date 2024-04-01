package com.usstudy.interviewproject.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "emloyee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "employee_number")
    private int employeeNumber;
    @Column(name = "employee_name")
    private String employeeName;
    private String phone ;
    private String position;
    private String email;
}
