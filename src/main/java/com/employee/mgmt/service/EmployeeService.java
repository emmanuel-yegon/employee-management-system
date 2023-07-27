package com.employee.mgmt.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmployeeService {

    ResponseEntity<String> addEmployee(Map<String, String> requestMap);

}
