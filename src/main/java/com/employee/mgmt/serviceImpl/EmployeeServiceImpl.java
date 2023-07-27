package com.employee.mgmt.serviceImpl;

import com.employee.mgmt.constants.EmployeeConstants;
import com.employee.mgmt.dao.EmployeeDao;
import com.employee.mgmt.model.Employee;
import com.employee.mgmt.service.EmployeeService;
import com.employee.mgmt.utils.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;


    @Override
    public ResponseEntity<String> addEmployee(Map<String, String> requestMap) {
        try {
            if (validateEmployeeMap(requestMap)){
                Employee employee = employeeDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(employee)){
                    employeeDao.save(getEmployeeFromMap(requestMap));
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

    private boolean validateEmployeeMap(Map<String, String> requestMap) {
        if (requestMap.containsKey("firstName") && requestMap.containsKey("lastName")
                && requestMap.containsKey("email") && requestMap.containsKey("contactNumber")){
            return true;
        }
        return false;
    }

    private Employee getEmployeeFromMap(Map<String,String> requetMap){
        Employee employee = new Employee();
        employee.setFirstName(requetMap.get("firstName"));
        employee.setLastName(requetMap.get("lastName"));
        employee.setEmail(requetMap.get("email"));
        employee.setContactNumber(requetMap.get("contactNumber"));
        employee.setStatus("false");
        employee.setRole("user");
        return employee;
    }
}
