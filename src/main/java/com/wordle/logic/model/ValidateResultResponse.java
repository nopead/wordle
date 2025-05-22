package logic.model;

public class ValidateResultResponse {

    private boolean isValid;
    private String validationErrorMessage;

    public ValidateResultResponse(boolean isValid, String validationErrorMessage) {
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
