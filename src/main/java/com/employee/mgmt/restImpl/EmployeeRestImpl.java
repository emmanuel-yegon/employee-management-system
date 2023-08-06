package com.employee.mgmt.restImpl;

import com.employee.mgmt.constants.EmployeeConstants;
import com.employee.mgmt.rest.EmployeeRest;
import com.employee.mgmt.service.EmployeeService;
import com.employee.mgmt.utils.EmployeeUtils;
import com.employee.mgmt.wrapper.EmployeeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public ResponseEntity<List<EmployeeWrapper>> getAllEmployees() {
        try {
            return employeeService.getAllEmployees();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<EmployeeWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateEmployee(Map<String, String> requestMap) {
        try {
            return employeeService.updateEmployee(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return EmployeeUtils.getResponseEntity(EmployeeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Integer id) {
        try {
            return employeeService.deleteEmployee(id);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return EmployeeUtils.getResponseEntity(EmployeeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<EmployeeWrapper> getEmployeeById(Integer id) {
        try {
            return employeeService.getEmployeeById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  new ResponseEntity<>(new EmployeeWrapper(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}