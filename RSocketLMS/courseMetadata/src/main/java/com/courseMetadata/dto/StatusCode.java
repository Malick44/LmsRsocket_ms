package com.courseMetadata.dto;

public enum StatusCode {
    E401("Unauthorized"),
    E403("Forbidden"),
    E404("Not Found"),
    E500("Internal Server Error");

    private final String description;

    StatusCode(String description) {
        this.description = description;
    }
}
