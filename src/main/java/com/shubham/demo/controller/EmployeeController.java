package com.shubham.demo.controller;

import com.shubham.demo.dto.ApiResponseDTO;
import com.shubham.demo.dto.EmployeeDTO;
import com.shubham.demo.model.Employee;
import com.shubham.demo.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shubh")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IEmployeeService employeeService;


    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        LOGGER.debug("Employee id: {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(new EmployeeDTO(employee));
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody Employee employee) {
        LOGGER.debug("Employee data before update: {}", employee);
        Employee savedEmployee =  employeeService.saveEmployee(employee);
        LOGGER.debug("Employee data after update: {}", savedEmployee);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new EmployeeDTO(savedEmployee));
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ApiResponseDTO> deleteById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        LOGGER.debug("Employee data deleted");
        return ResponseEntity.ok(new ApiResponseDTO("success", "Employee with id: " + id + " has been deleted"));

    }


}
