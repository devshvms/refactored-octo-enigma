package in.dev.shvms.refactoredoctoenigma.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    HttpStatus httpStatus;
    String errorMsg;

    public ErrorResponse(HttpStatus httpStatus, String msg) {
        this.httpStatus = httpStatus;
        this.errorMsg = msg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
