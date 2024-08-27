package smartbox.handling_request.validator.Transaction_Id;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;
import smartbox.handling_request.services.ValidMessageService;

public class TransactionIdValidator implements ConstraintValidator<ValidTransactionId, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;
    @Autowired
    private ValidMessageService validMessageService;

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object transactionId = value.getTransactionId();
        if (transactionId==null){
           updateReponseWithError(value.getId_message(), "TX_ID_NULL_ERR", "Transaction ID cannot be null.",context);
           return false;
        }else{
        if (!(transactionId instanceof Integer)) {
            updateReponseWithError(value.getId_message(), "TX_ID_TYPE_ERR", "Transaction ID must be an Integer.", context);
            return false;
        }else {

            Integer transactionIdValue = (Integer) transactionId;

            if (transactionIdValue == null || transactionIdValue == 0) {
                updateReponseWithError(value.getId_message(), "TX_ID_ZERO_ERR", "Transaction ID cannot be null or zero.", context);
                return false;
            } else if (String.valueOf(transactionIdValue).length() > 10) {
                updateReponseWithError(value.getId_message(), "TX_ID_LEN_ERR", "Transaction ID must be between 1 and 10 digits.", context);
                return false;
            }else if(validMessageService.findMessageByTransactionId(transactionIdValue)){
                updateReponseWithError(value.getId_message(), "TX_ID_DUPLICATE_ERR", "Transaction ID must be unique.", context);
                return false;
            }
        }}
        return true;
    }

    private void updateReponseWithError(int messageId, String errorCode, String errorMessage, ConstraintValidatorContext context) {
        Reponse reponse = reponseService.findByid_message(messageId);
        reponse.setStatus(0);
        if (reponse.getCode() != null) {
            reponse.setCode(reponse.getCode() + "/" + errorCode);
        } else {
            reponse.setCode(errorCode);
        }
        reponserep.save(reponse);
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode("Transaction ID")
                .addConstraintViolation();
    }
}
