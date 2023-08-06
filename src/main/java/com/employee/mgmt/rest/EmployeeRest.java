package com.employee.mgmt.rest;

import com.employee.mgmt.wrapper.EmployeeWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/api/v1/employees")
public interface EmployeeRest {

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody(required = true)Map<String,String> requestMap);

    @GetMapping
    public ResponseEntity<List<EmployeeWrapper>> getAllEmployees();

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody(required = true)Map<String, String> requestMap);

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id);

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeWrapper> getEmployeeById(@PathVariable Integer id);
}
