package com.employee.mgmt.rest;

import com.employee.mgmt.wrapper.EmployeeWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/employee")
public interface EmployeeRest {

    @PostMapping(path = "/add")
    public ResponseEntity<String> addEmployee(@RequestBody(required = true)Map<String,String> requestMap);

    @GetMapping(path = "/get")
    public ResponseEntity<List<EmployeeWrapper>> getAllEmployee();

    @PostMapping(path = "/update")
    public ResponseEntity<String> updateEmployee(@RequestBody(required = true)Map<String, String> requestMap);

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id);

}
