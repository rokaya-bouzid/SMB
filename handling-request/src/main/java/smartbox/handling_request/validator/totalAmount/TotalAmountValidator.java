package smartbox.handling_request.validator.totalAmount;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;

public class TotalAmountValidator implements ConstraintValidator<ValidTotalAmount, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;

    @Override
    public void initialize(ValidTotalAmount constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object totalAmount = value.getTotalAmount();
        if (totalAmount == null) {
            return handleValidationFailure(value, context, "Total amount cannot be null .", "TM_NULL_ERR.");
        }else{

        if (!(totalAmount instanceof Integer)) {
            return handleValidationFailure(value, context, "Total amount must be Integer .", "TM_TYPE_ERR");
        }else {

            Integer totalAmountValue = (Integer) totalAmount;

            if(totalAmountValue<0){
                return handleValidationFailure(value, context, "The total amount must be greater than zero.", "TM_Negative_ERR");

            }


        }}

        return true;
    }

    private boolean handleValidationFailure(Recivied_messageRequest value, ConstraintValidatorContext context,
                                            String errorMessage, String responseCode) {
        Reponse reponse = reponseService.findByid_message(value.getId_message());
        reponse.setStatus(0);

        if (reponse.getCode() != null) {
            reponse.setCode(reponse.getCode() + "/" + responseCode);
        } else {
            reponse.setCode(responseCode);
        }

        reponserep.save(reponse);

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode("totalAmount")
                .addConstraintViolation();

        return false;
    }
}
