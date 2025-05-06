package logic;

import java.util.Optional;

public class ValidateResult {

    private boolean isValid;
    private String validationErrorMessage;

    public ValidateResult(boolean isValid, String validationErrorMessage) {
        this.isValid = isValid;
        this.validationErrorMessage = validationErrorMessage;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getValidationErrorMessage() {
        return validationErrorMessage;
    }

}
