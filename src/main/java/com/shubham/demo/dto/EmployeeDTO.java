package com.shubham.demo.dto;

import com.shubham.demo.model.Employee;

public class EmployeeDTO {

    private Integer id;
    private String name;
    private String address;
    private String role;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.address = employee.getAddress();
        this.role = employee.getRole();
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
