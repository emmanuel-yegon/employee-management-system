package com.employee.mgmt.utils;

import com.employee.mgmt.wrapper.EmployeeWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeUtils {

    public EmployeeUtils() {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return  new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
    }

}
