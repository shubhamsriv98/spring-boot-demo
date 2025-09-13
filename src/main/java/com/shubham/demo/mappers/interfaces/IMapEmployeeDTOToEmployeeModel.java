package com.shubham.demo.mappers.interfaces;

import com.shubham.demo.dto.EmployeeDTO;
import com.shubham.demo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Here an implementation class will be generated with name "MapEmployeeDTOToEmployeeModel"
 * and will be annotated with @Component so that during scanning it get register as a bean,
 * and you can simply inject and use it. This is happening because you have written componentModel ="spring"
 * If you have written componentModel ="default" in that case also one implementation class will be generated but
 * without @Component due to which you can not inject it.
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        implementationName = "MapEmployeeDTOToEmployeeModel",
        implementationPackage = "com.shubham.demo.mappers.implementation")
public interface IMapEmployeeDTOToEmployeeModel {

    //@Mapping(target = "id", ignore = true)
    Employee mapEmployeeDTOToEmployeeModel(EmployeeDTO employee);

}
