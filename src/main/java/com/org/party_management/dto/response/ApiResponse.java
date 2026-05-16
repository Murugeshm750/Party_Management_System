package com.org.party_management.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private String status;

    private int statusCode;

    private String message;

    private T data;

    // SUCCESS RESPONSE
    public static <T> ApiResponse<T> success(
            int statusCode,
            String message,
            T data
    ) {

        return ApiResponse.<T>builder()
                .status("success")
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .build();
    }

    // ERROR RESPONSE
    public static <T> ApiResponse<T> error(
            int statusCode,
            String message
    ) {

        return ApiResponse.<T>builder()
                .status("error")
                .statusCode(statusCode)
                .message(message)
                .data(null)
                .build();
    }
}