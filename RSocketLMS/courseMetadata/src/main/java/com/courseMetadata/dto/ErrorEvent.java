package com.courseMetadata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorEvent {
    private StatusCode statusCode;
    private String errorMessage;
    private LocalDateTime dateTime = LocalDateTime.now();
    private String path;
}
