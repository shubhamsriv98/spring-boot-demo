package com.shubham.demo.service;

import com.shubham.demo.dto.EmployeeDTO;

public interface IEmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    void deleteEmployeeById(Integer id);

    EmployeeDTO getEmployeeById(Integer id);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployeeById(Integer id, EmployeeDTO employeeDTO);
}
