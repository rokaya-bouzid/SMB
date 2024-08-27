package smartbox.handling_request.validator.CanisterNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;

public class CanisterNumberValidator implements ConstraintValidator<ValidCanisterNumber, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;

    @Override
    public void initialize(ValidCanisterNumber constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object canisterNumber = value.getCanisterNumber();
        if (canisterNumber==null ) {
            updateReponseWithError(value.getId_message(), "CANISTER_NUMBER_NULL_ERR", "Canister number cannot be null.", context);
            return false;
        }else {

        if (!(canisterNumber instanceof Integer)) {
            updateReponseWithError(value.getId_message(), "CANISTER_NUMBER_TYPE_ERR", "Canister number must be an Integer.", context);
            return false;
        }else{

        String canisterNumberStr = canisterNumber.toString();

        if (!canisterNumberStr.matches("\\d{6}")) {
            updateReponseWithError(value.getId_message(), "CANISTER_NUMBER_FORMAT_ERR", "The canister number must be a 6-digit number.", context);
            return false;
        }}}

        return true;
    }

    private void updateReponseWithError(int messageId, String errorCode, String errorMessage, ConstraintValidatorContext context) {
        Reponse reponse = reponseService.findByid_message(messageId);
        reponse.setStatus(0);
        reponse.setCode(reponse.getCode() != null ? reponse.getCode() + "/" + errorCode : errorCode);
        reponserep.save(reponse);

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode("canisterNumber")
                .addConstraintViolation();
    }
}
