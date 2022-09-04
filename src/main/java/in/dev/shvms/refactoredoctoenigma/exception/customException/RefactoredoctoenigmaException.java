package in.dev.shvms.refactoredoctoenigma.exception.customException;

import in.dev.shvms.refactoredoctoenigma.exception.ErrorResponse;

public class RefactoredoctoenigmaException extends RuntimeException{
    ErrorResponse errorResponse;

    public RefactoredoctoenigmaException () {

    }
    public RefactoredoctoenigmaException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public RefactoredoctoenigmaException(Throwable cause, ErrorResponse errorResponse) {
        super(errorResponse.getErrorMsg(), cause);
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return this.errorResponse;
    }
}
