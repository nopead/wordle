package com.wordle.logic.model;

import com.wordle.logic.enums.ValidationError;
import java.util.List;

public class ValidateResultResponse {

    private boolean isValid;
    List<ValidationError> validationErrors;

    public ValidateResultResponse(boolean isValid, List<ValidationError> errors) {
        this.isValid = isValid;
        this.validationErrors = errors;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

}
