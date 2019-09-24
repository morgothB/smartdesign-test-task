package restservice.json;

public class ExceptionResponse {

    private long timestamp;
    private long code;
    private String message;

    public ExceptionResponse() {
    }

    public ExceptionResponse(long timestamp, long code, String message) {
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
