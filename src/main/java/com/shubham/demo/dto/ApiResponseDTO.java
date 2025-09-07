package com.shubham.demo.dto;

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
