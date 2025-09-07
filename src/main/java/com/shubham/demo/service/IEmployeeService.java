package com.shubham.demo.service;

import com.shubham.demo.model.Employee;

public interface IEmployeeService {

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Integer id);

    Employee getEmployeeById(Integer id);
}
