package logic;

public class RecordAttemptResponse {

    private boolean success;
    private String message;

    public RecordAttemptResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
