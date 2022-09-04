package in.dev.shvms.refactoredoctoenigma.exception;

import in.dev.shvms.refactoredoctoenigma.exception.customException.RefactoredoctoenigmaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeling {

    @ExceptionHandler(RefactoredoctoenigmaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCustomException(RefactoredoctoenigmaException rx) {
        return rx.getErrorResponse();
    }
}
