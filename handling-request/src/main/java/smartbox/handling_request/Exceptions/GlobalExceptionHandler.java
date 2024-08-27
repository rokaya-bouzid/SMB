package smartbox.handling_request.Exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();

        // Add fields with errors and their messages
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            // Attempt to get the original field value
            Object fieldValue = null;
            try {
                fieldValue = ex.getBindingResult().getTarget()
                        .getClass()
                        .getDeclaredField(error.getField())
                        .get(ex.getBindingResult().getTarget());
            } catch (Exception e) {
                // Handle reflection errors
            }
            // Populate the response with field value or error message
            response.put(error.getField(), fieldValue != null ? fieldValue : error.getDefaultMessage());
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String[] segments = fieldName.split("\\.");
            fieldName=segments[segments.length - 1];
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
