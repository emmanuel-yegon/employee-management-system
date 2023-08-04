package com.employee.mgmt.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeWrapper {

    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String contact_number;
    public EmployeeWrapper(Integer id, String first_name, String last_name, String email, String contact_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.contact_number = contact_number;
    }
}
