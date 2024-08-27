package SmartBox.MerchantMangement.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

public class GlobalHandler {
    @ExceptionHandler(value = {ExceptionEntityNotFound.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(ExceptionEntityNotFound ex) {
        ErrorMessage errorResponse = new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage(),new Date());
        return null;
    }
}
