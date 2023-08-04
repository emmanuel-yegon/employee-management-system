package com.employee.mgmt.serviceImpl;

import com.employee.mgmt.constants.EmployeeConstants;
import com.employee.mgmt.dao.EmployeeDao;
import com.employee.mgmt.model.Employee;
import com.employee.mgmt.service.EmployeeService;
import com.employee.mgmt.utils.EmployeeUtils;
import com.employee.mgmt.wrapper.EmployeeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;


    @Override
    public ResponseEntity<String> addEmployee(Map<String, String> requestMap) {
        try {
            if (validateEmployeeMap(requestMap,false)){
                Employee employee = employeeDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(employee)){
                    employeeDao.save(getEmployeeFromMap(requestMap, false));
                    return EmployeeUtils.getResponseEntity("Employee Added Successfully.", HttpStatus.OK);
                }else {
                    return EmployeeUtils.getResponseEntity("Email already exists.", HttpStatus.BAD_REQUEST);
                }
            }else {
                return EmployeeUtils.getResponseEntity(EmployeeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return EmployeeUtils.getResponseEntity(EmployeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    private boolean validateEmployeeMap(Map<String, String> requestMap, boolean validateId) {
        if ( requestMap.containsKey("email")){
            if (requestMap.containsKey("id") && validateId){
                return true;
            } else if(!validateId){
                return  true;
            }
        }
        return false;
    }

    private Employee getEmployeeFromMap(Map<String,String> requetMap, Boolean isAdd){
        Employee employee = new Employee();
        if (isAdd){
            employee.setId(Integer.parseInt(requetMap.get("id")));
        }
        employee.setFirstName(requetMap.get("firstName"));
        employee.setLastName(requetMap.get("lastName"));
        employee.setContactNumber(requetMap.get("contactNumber"));
        employee.setEmail(requetMap.get("email"));

        return employee;
    }

    @Override
    public ResponseEntity<List<EmployeeWrapper>> getAllEmployees() {
        try {
            return new ResponseEntity<>(employeeDao.getAllEmployees(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateEmployee(Map<String, String> requestMap) {
        try {
            if (validateEmployeeMap(requestMap, true)){
                Optional<Employee> optional = employeeDao.findById(Integer.parseInt(requestMap.get("id")));
                if (!optional.isEmpty()){
                    Employee employee = getEmployeeFromMap(requestMap,true);
                    employeeDao.save(employee);
                    return EmployeeUtils.getResponseEntity("Employee Updated Successfully",HttpStatus.OK);
                } else {
                    return  EmployeeUtils.getResponseEntity("Employee id does not exist", HttpStatus.BAD_REQUEST);
                }
            }else {
                return EmployeeUtils.getResponseEntity(EmployeeConstants.INVALID_DATA,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return EmployeeUtils.getResponseEntity(EmployeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Integer id) {
        try {
            Optional optional = employeeDao.findById(id);
            if (!optional.isEmpty()){
                employeeDao.deleteById(id);
                return EmployeeUtils.getResponseEntity("Employee Deleted Successfully",HttpStatus.OK);
            }
            return EmployeeUtils.getResponseEntity("Employee id does not exist", HttpStatus.BAD_REQUEST);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return EmployeeUtils.getResponseEntity(EmployeeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
