package com.employee.mgmt.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@NamedQuery(name = "Employee.findByEmailId", query = "select e from Employee e where e.email=:email")

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "pg_employee", schema = "ems")
public class Employee implements Serializable {

    private static final  long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

}
