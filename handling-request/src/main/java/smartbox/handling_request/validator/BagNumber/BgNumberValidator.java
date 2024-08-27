package smartbox.handling_request.validator.BagNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;

public class BgNumberValidator implements ConstraintValidator<ValidBgNumber, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;

    @Override
    public void initialize(ValidBgNumber constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object bagNumber = value.getBagNumber();
        if ((bagNumber==  null)) {
            updateReponseWithError(value.getId_message(), "BAG_NUMBER_NULL_ERR", "The bag number cannot be null.", context);
            return false;
        }else {

        if (!(bagNumber instanceof String)) {
            updateReponseWithError(value.getId_message(), "BAG_NUMBER_TYPE_ERR", "The bag number must be a String.", context);
            return false;
        }else {

            String bagNumberStr = (String) bagNumber;

            if (bagNumberStr == null || bagNumberStr.length() != 14 || !bagNumberStr.matches("[a-zA-Z0-9]+")) {
                updateReponseWithError(value.getId_message(), "BAG_NUMBER_FORMAT_ERR", "The bag number must be exactly 14 alphanumeric characters.", context);
                return false;
            }
        }}
        return true;
    }

    private void updateReponseWithError(int messageId, String errorCode, String errorMessage, ConstraintValidatorContext context) {
        Reponse reponse = reponseService.findByid_message(messageId);
        reponse.setStatus(0);
        reponse.setCode(reponse.getCode() != null ? reponse.getCode() + "/" + errorCode : errorCode);
        reponserep.save(reponse);

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode("bagNumber")
                .addConstraintViolation();
    }
}
