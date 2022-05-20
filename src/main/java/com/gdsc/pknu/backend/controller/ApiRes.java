package com.gdsc.pknu.backend.controller;

import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

@Getter
public class ApiRes<T> {

    private final boolean success;

    private final T response;

    private final ApiError error;

    public ApiRes(boolean success, T response, ApiError error) {
        this.success = success;
        this.response = response;
        this.error = error;
    }

    public static <T> ApiRes<T> SUCCESS(T response){
        return new ApiRes<>(true, response, null);
    }

    public static <T> ApiRes<T> ERROR(String msg, HttpStatus status){
        return new ApiRes<>(false, null, new ApiError(msg, status));
    }

    public static <T> ApiRes<T> ERROR(Throwable throwable, HttpStatus status){
        return new ApiRes<>(false, null, new ApiError(throwable, status));
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("success", success)
                .append("response", response)
                .append("error", error)
                .toString();
    }
}
