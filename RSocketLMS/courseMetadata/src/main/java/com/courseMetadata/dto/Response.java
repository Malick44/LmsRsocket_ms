package com.courseMetadata.dto;

import java.util.Objects;

public class Response<T>{
    ErrorEvent ErrorResponse;
    T successResponse;

public Response(T successResponse) {

        this.successResponse = successResponse;
    }
    public Response(ErrorEvent errorResponse ) {
        this.ErrorResponse = errorResponse;
    }

public boolean hasError() {
        return Objects.nonNull(this.ErrorResponse);
    }

    public T getSuccessResponse() {
        return successResponse;
    }

    public static <T> Response<T> with(T successResponse) {
        return new Response<>(successResponse);
    }

    public static <T> Response<T> with(ErrorEvent errorResponse) {
        return new Response<>(errorResponse);
    }
}
