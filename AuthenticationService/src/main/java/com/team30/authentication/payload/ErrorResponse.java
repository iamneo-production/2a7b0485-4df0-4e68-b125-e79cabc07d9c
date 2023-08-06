package com.team30.authentication.payload;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class ErrorResponse {
    private String message;
    private String status;
    private HttpStatus httpStatus;
}
