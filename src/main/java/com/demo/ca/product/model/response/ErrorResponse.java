package com.demo.ca.product.model.response;

import com.demo.ca.product.constants.ErrorResponseCodes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Suresh Chaudhari
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse implements Serializable {
    private String message;
    private String description;
    private String cause;
    private String moreInfo;

    public ErrorResponse(String cause, String message, String description) {
        this.cause = cause;
        this.message = message;
        this.description = description;
    }

    public ErrorResponse(ErrorResponseCodes error){
        this.cause = error.getCause();
        this.message = error.getMessage();
        this.description = error.getDescription();
    }
}
