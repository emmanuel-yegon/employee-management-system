package com.employee.mgmt.dao;

import com.employee.mgmt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Employee findByEmailId(@Param("email") String email);

}
