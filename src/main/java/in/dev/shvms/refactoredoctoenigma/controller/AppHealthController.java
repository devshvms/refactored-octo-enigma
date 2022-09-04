package in.dev.shvms.refactoredoctoenigma.controller;


import in.dev.shvms.refactoredoctoenigma.exception.ErrorResponse;
import in.dev.shvms.refactoredoctoenigma.exception.customException.RefactoredoctoenigmaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
public class AppHealthController {

    @GetMapping("/")
    public String index() {
        return "Hit success!";
    }

    @GetMapping("/ping/{pingString}")
    public String ping(@PathVariable String pingString) {
        return pingString+" successful";
    }

    @GetMapping("/exception/{errorResponseCode}")
    public String exceptionThrower(@PathVariable String errorResponseCode) {
        try {
            Integer statusCode = Integer.valueOf(errorResponseCode);
            HttpStatus httpStatus = HttpStatus.resolve(statusCode);
            if (Objects.isNull(httpStatus)) {
                throw new RefactoredoctoenigmaException(new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid HTTP-CODE. "+ errorResponseCode + " Does not exist"));
            }
            throw new ResponseStatusException(httpStatus, "Successfully parsed HTTP-CODE and thrown wrapped custom Exception.");
        } catch(NumberFormatException nex)  {
            throw new RefactoredoctoenigmaException(new ErrorResponse(HttpStatus.BAD_REQUEST, "Expecting HTTP-CODE not " +errorResponseCode));
        }
    }

}
