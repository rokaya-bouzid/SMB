package smartbox.handling_request.validator.TransmissionDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.repositories.ValidMessagesREp;
import smartbox.handling_request.services.ReponseService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransmissionDateValidator implements ConstraintValidator<ValidTransmissionDate, Recivied_messageRequest> {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSS";

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;
    @Autowired
    private ValidMessagesREp validMessagesREp;
    @Override
    public void initialize(ValidTransmissionDate constraintAnnotation) {
        // Initialization, if needed
    }
    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object transmissionDate = value.getTransmissionDate();
       if (transmissionDate==null){
           return handleValidationFailure(value, context, "TD_NULL_ERR", "Transmission Date cannot be null.");

       }else {
           if (!(transmissionDate instanceof String)) {
               return handleValidationFailure(value, context, "TD_TYPE_ERR", "Transmission Date must be a String.");
           }else {

           String transmissionDateStr = (String) transmissionDate;
           if (!isValidDateFormat(transmissionDateStr)) {
               return handleValidationFailure(value, context, "TD_FMT_ERR",
                       "Invalid Transmission Date format. Expected format is 'yyyy-MM-dd HH:mm:ss.SSSSS'.");
           }else if(!validMessagesREp.findByTransmissionDate(transmissionDateStr).isEmpty()){
               return handleValidationFailure(value, context, "TD_DUp_ERR",
                       "Transmission Date is duplicated");
           }

           }
       }
        return true;
    }
    private boolean isValidDateFormat(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);

        try {
            Date parsedDate = dateFormat.parse(dateStr);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private boolean handleValidationFailure(Recivied_messageRequest value, ConstraintValidatorContext context,
                                            String errorCode, String errorMessage) {
        Reponse reponse = reponseService.findByid_message(value.getId_message());
        reponse.setStatus(0);

        if (reponse.getCode() != null) {
            reponse.setCode(reponse.getCode() + "/" + errorCode);
        } else {
            reponse.setCode(errorCode);
        }
        reponserep.save(reponse);

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode("transmissionDate")
                .addConstraintViolation();

        return false;
    }
}
