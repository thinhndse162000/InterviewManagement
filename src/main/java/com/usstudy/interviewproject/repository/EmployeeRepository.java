package com.usstudy.interviewproject.repository;

import com.usstudy.interviewproject.domain.dto.request.EmployeeSearchRequest;
import com.usstudy.interviewproject.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e ORDER BY e.employeeName")
    List<Employee> getByNameOrder();

    @Query("SELECT e FROM Employee e"
            +" WHERE (:#{#req.employeeName} is null OR e.employeeName like %:#{#req.employeeName}%) "
            +" AND (:#{#req.email} is null OR e.email like %:#{#req.email}%)"
            +" AND (:#{#req.position} is null OR e.position like %:#{#req.position}%)"
            +" AND (:#{#req.phone} is null OR e.phone like %:#{#req.phone}%)"
            +" AND (:#{#req.employeeNumber} = 0 OR e.employeeNumber = :#{#req.employeeNumber})"
    )
    List<Employee> filterEmployee(@Param(value = "req") EmployeeSearchRequest req);
}
