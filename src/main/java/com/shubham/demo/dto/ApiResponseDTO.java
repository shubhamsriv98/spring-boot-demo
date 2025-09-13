package com.shubham.demo.dto;


/**
 * This class is use to receive and sending request to the client. It will not interact with DB.
 **/
public class ApiResponseDTO {
    private String status;
    private String message;

    public ApiResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
