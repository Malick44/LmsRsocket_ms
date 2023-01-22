package com.courseMetadata.dto;

import java.util.Objects;

public class CallResponse <T>{
    ErrorEvent ErrorResponse;
    T successResponse;

public CallResponse(T successResponse) {

        this.successResponse = successResponse;
    }
    public CallResponse(ErrorEvent errorResponse ) {
        this.ErrorResponse = errorResponse;
    }

public boolean hasError() {
        return Objects.nonNull(this.ErrorResponse);
    }

    public T getSuccessResponse() {
        return successResponse;
    }

    public static <T>CallResponse<T> with(T successResponse) {
        return new CallResponse<>(successResponse);
    }

    public static <T>CallResponse<T> with(ErrorEvent errorResponse) {
        return new CallResponse<>(errorResponse);
    }
}
