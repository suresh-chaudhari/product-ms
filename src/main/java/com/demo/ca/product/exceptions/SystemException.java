package com.demo.ca.product.exceptions;

import com.demo.ca.product.constants.ErrorResponseCodes;
import com.demo.ca.product.model.response.ErrorResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Suresh Chaudhari
 */

@Getter
@Setter
public class SystemException extends RuntimeException {

    private HttpStatus httpStatus;
    private ErrorResponse errorResponse;

    public SystemException(ErrorResponseCodes responseCode) {
        super(responseCode.getDescription());
        httpStatus = responseCode.getHttpStatus();
        errorResponse = new ErrorResponse(responseCode.getCause(), responseCode.getMessage(), responseCode.getDescription());
    }

    public SystemException(HttpStatus httpStatus, ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.httpStatus = httpStatus;
        this.errorResponse = errorResponse;
    }
}
