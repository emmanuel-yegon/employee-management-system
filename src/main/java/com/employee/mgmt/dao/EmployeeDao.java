package com.employee.mgmt.dao;

import com.employee.mgmt.model.Employee;
import com.employee.mgmt.wrapper.EmployeeWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Employee findByEmailId(@Param("email") String email);

    List<EmployeeWrapper> getAllEmployee();

}
