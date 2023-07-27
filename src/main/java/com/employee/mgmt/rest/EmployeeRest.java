package com.employee.mgmt.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PublicKey;
import java.util.Map;

@RequestMapping(path = "/employee")
public interface EmployeeRest {

    @PostMapping(path = "/add")
    public ResponseEntity<String> addEmployee(@RequestBody(required = true)Map<String,String> requestMap);
}
