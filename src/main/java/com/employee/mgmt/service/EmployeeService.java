package com.employee.mgmt.service;

import com.employee.mgmt.wrapper.EmployeeWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    ResponseEntity<String> addEmployee(Map<String, String> requestMap);

    ResponseEntity<List<EmployeeWrapper>> getAllEmployees();

    ResponseEntity<String> updateEmployee(Map<String, String> requestMap);

    ResponseEntity<String> deleteEmployee(Integer id);

    ResponseEntity<EmployeeWrapper> getEmployeeById(Integer id);

}
