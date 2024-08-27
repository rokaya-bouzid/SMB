package smartbox.handling_request.validator.currency;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;

public class currencyValidator implements ConstraintValidator<Validcurrency, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;

    @Override
    public void initialize(Validcurrency constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object currency = value.getCurrency();

        if (( currency == null)) {
            updateReponseWithError(value.getId_message(), "CURR_NULL_ERR", "Currency must not be null.", context);
            return false;
        }else{
            if (!(currency instanceof String)) {
            updateReponseWithError(value.getId_message(), "CURR_TYPE_ERR", "Currency must be a String.", context);
            return false;
            }else{

        String currencyStr = (String) currency;

        if ( !currencyStr.equals("ZAR")) {
            updateReponseWithError(value.getId_message(), "CURR_INVALID_ERR", "Invalid currency.", context);
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
                .addPropertyNode("currency")
                .addConstraintViolation();
    }
}
