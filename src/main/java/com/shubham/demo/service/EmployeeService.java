package com.shubham.demo.service;

import com.shubham.demo.dto.EmployeeDTO;
import com.shubham.demo.mappers.interfaces.IMapEmployeeDTOToEmployeeModel;
import com.shubham.demo.mappers.interfaces.IMapEmployeeModelToEmployeeDTO;
import com.shubham.demo.model.Employee;
import com.shubham.demo.repository.IEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IMapEmployeeDTOToEmployeeModel mapEmployeeDTOToEmployeeModel;

    @Autowired
    private IMapEmployeeModelToEmployeeDTO mapEmployeeModelToEmployeeDTO;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapEmployeeDTOToEmployeeModel.mapEmployeeDTOToEmployeeModel(employeeDTO);
        return mapEmployeeModelToEmployeeDTO.mapEmployeeModelToEmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        return mapEmployeeModelToEmployeeDTO.mapEmployeeModelToEmployeeDTO(employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found")));
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapEmployeeDTOToEmployeeModel.mapEmployeeDTOToEmployeeModel(employeeDTO);
        Employee fetchedEmployee = employeeRepository.findById(employee.getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        fetchedEmployee.setName(employeeDTO.getName());
        fetchedEmployee.setAddress(employeeDTO.getAddress());
        fetchedEmployee.setRole(employeeDTO.getRole());
        fetchedEmployee.setAddress(employeeDTO.getAddress());
        return mapEmployeeModelToEmployeeDTO.mapEmployeeModelToEmployeeDTO(employeeRepository.save(fetchedEmployee));
    }

    @Override
    public EmployeeDTO updateEmployeeById(Integer id, EmployeeDTO employeeDTO) {
       Employee employee = employeeRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Employee not found"));
       if(employeeDTO == null) {
           LOGGER.debug("Received Employee Data is null");
           return null;
       }
       if(employeeDTO.getAddress() != null) {
            employee.setAddress(employeeDTO.getAddress());
       }
        return mapEmployeeModelToEmployeeDTO.mapEmployeeModelToEmployeeDTO(employeeRepository.save(employee));
    }


}
