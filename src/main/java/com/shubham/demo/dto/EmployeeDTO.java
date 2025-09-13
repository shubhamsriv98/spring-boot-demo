package com.shubham.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * This class is use to receive and sending request to the client. It will not interact with DB.
**/
public class EmployeeDTO {


    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "Role cannot be blank")
    private String role;

    /**
     * I have commented below code because i'm using advance feature of spring which is below in parametrized constructor.
     */
    //public EmployeeDTO() {
        /*
         * specially this approach is used in case of option fields.
         * Needed by Jackson.
         * fields are non-final and have default package-private access, Jackson can directly access fields via reflection.
         * So even without setters, no-arg constructor, reflection allows Jackson to populate the fields,
         * specially in the case of post mapping, where data need to mapped from Json Object to Java Object.
         */
   // }

    /**
     * @param name
     * @param address
     * @param role
     * Advanced, Jackson builds object directly from JSON.
     * Enforces object validity → All required fields must be provided during creation.
     * If JSON has missing fields, object creation fails immediately.
     */
    @JsonCreator
    public EmployeeDTO(@JsonProperty String name, @JsonProperty String address, @JsonProperty String role, @JsonProperty Integer id) {
        this.name = name;
        this.address = address;
        this.role = role;
        this.id = id;
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

    public Integer getId() {
        return id;
    }
}
