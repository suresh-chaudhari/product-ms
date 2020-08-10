package com.demo.ca.product.exceptions;

import com.demo.ca.product.model.response.ErrorResponse;
import com.demo.ca.product.constants.ErrorResponseCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Suresh Chaudhari
 */

@Getter
@Setter
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private HttpStatus httpStatus;
    private ErrorResponse errorResponse;

    public ServiceException(ErrorResponseCodes responseCode) {
        super(responseCode.getDescription());
        httpStatus = responseCode.getHttpStatus();
        errorResponse = new ErrorResponse(responseCode.getCause(), responseCode.getMessage(), responseCode.getDescription());
    }
}
