package com.shubham.demo.mappers.interfaces;

import com.shubham.demo.dto.EmployeeDTO;
import com.shubham.demo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        implementationName = "MapEmployeeModelToEmployeeDTO",
        implementationPackage = "com.shubham.demo.mappers.implementation")
public interface IMapEmployeeModelToEmployeeDTO {

    EmployeeDTO mapEmployeeModelToEmployeeDTO(Employee employee);
}
