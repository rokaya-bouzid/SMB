package smartbox.handling_request.validator.Status;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;

public class StatusValidator implements ConstraintValidator<ValidStatus, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;

    @Override
    public void initialize(ValidStatus constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object statusObj = value.getStatus();

        if (statusObj == null) {
            updateReponseWithError(value.getId_message(), "STATUS_NULL_ERR", "Status must not be null.", context);
            return false;
        }

        if (!(statusObj instanceof String)) {
            updateReponseWithError(value.getId_message(), "STATUS_TYPE_ERR", "Status must be a String.", context);
            return false;
        }

        String status = (String) statusObj;

        if (!"000".equals(status)) {
            updateReponseWithError(value.getId_message(), "STATUS_INVALID_ERR", "Status indicates failure.", context);
            return false;
        }

        return true;
    }

    private void updateReponseWithError(int messageId, String errorCode, String errorMessage, ConstraintValidatorContext context) {
        Reponse reponse = reponseService.findByid_message(messageId);
        reponse.setStatus(0);
        reponse.setCode(reponse.getCode() != null ? reponse.getCode() + "/" + errorCode : errorCode);
        reponserep.save(reponse);

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode("Status")
                .addConstraintViolation();
    }
}
