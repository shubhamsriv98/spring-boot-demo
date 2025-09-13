package com.shubham.demo.controller;

import com.shubham.demo.dto.ApiResponseDTO;
import com.shubham.demo.dto.EmployeeDTO;
import com.shubham.demo.service.IEmployeeService;
import jakarta.validation.Valid;
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
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDTO);
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        LOGGER.debug("Employee data before persist: {}", employeeDTO);
        EmployeeDTO savedEmployee =  employeeService.saveEmployee(employeeDTO);
        LOGGER.debug("Employee data after persist: {}", savedEmployee);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeDTO);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ApiResponseDTO> deleteById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        LOGGER.debug("Employee data deleted");
        return ResponseEntity.ok(new ApiResponseDTO("success", "Employee with id: " + id + " has been deleted"));

    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<EmployeeDTO> updatePerson(@Valid @RequestBody EmployeeDTO employeeDTO) {
        LOGGER.debug("Employee data before update: {}", employeeDTO);
        EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployee(employeeDTO);
        LOGGER.debug("Employee data after update: {}", employeeDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(updatedEmployeeDTO);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateById(@PathVariable Integer id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        LOGGER.debug("Employee id: {} and Employee Data: {}",id, employeeDTO);
        EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployeeById(id, employeeDTO);
        LOGGER.debug("Employee data after partial update: {}", employeeDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(updatedEmployeeDTO);
    }


}
