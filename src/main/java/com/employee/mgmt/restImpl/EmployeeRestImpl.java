package com.employee.mgmt.restImpl;

import com.employee.mgmt.constants.EmployeeConstants;
import com.employee.mgmt.rest.EmployeeRest;
import com.employee.mgmt.service.EmployeeService;
import com.employee.mgmt.utils.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeRestImpl implements EmployeeRest {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ResponseEntity<String> addEmployee(Map<String, String> requestMap) {
        try {
            return employeeService.addEmployee(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return EmployeeUtils.getResponseEntity(EmployeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
;