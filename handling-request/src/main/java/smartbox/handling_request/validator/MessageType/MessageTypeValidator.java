package smartbox.handling_request.validator.MessageType;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.repositories.ValidMessagesREp;
import smartbox.handling_request.services.ReponseService;

import java.util.ArrayList;
import java.util.List;

public class MessageTypeValidator implements ConstraintValidator<ValidMessageType, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;
    @Autowired
    private ValidMessagesREp validMessagesREp;

    @Override
    public void initialize(ValidMessageType constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object indicator = value.getMessageType();
        Object MerchantNumber= value.getMerchantNumber();
        Object SequenceNumber =value.getSequenceNumber();
        Object  DepositReference=value.getDepositReference();
        Object CashCentreCode =value.getCashCentreCode();
        Object CashCenterType=value.getCashCentreType();
        if (indicator == null) {
            updateReponseWithError(value.getId_message(), "MSG_TYPE_NULL_EMPTY_ERR", "Message type cannot be null or empty.", context,"MessageType");
            return false;
        }else{
            if (!(indicator instanceof String)) {
                updateReponseWithError(value.getId_message(), "MSG_TYPE_TYPE_ERR", "Message type must be a String.", context,"MessageType");
                return false;
            }else{

                String indicator1 = (String) indicator;
                if (indicator1.length() != 1 || !("D".equals(indicator1) || "R".equals(indicator1) || "V".equals(indicator1))) {
                    updateReponseWithError(value.getId_message(), "MSG_TYPE_INVALID_ERR", "Message type must be 'D', 'R', or 'V'.", context,"MessageType");
                    return false;}
                else{
                    List<String[]> errorList = new ArrayList<>();
                       if(indicator1.equals("D")){

                        if (MerchantNumber == null) {
                            errorList.add(new String[]{"MerchantNumber_NULL_ERR", "Merchant Number cannot be null", "MerchantNumber"});
                        } else if (!(MerchantNumber instanceof Integer)) {
                            errorList.add(new String[]{"MerchantNumber_TYPE_ERR", "Merchant Number must be Integer", "MerchantNumber"});
                        }}

                        // Validate SequenceNumber
                        if (indicator1.equals("D") || indicator1.equals("R")) {
                            if (SequenceNumber == null) {
                                errorList.add(new String[]{"SequenceNumber_NULL_ERR", "Sequence Number cannot be null", "SequenceNumber"});
                            } else if (!(SequenceNumber instanceof Integer)) {
                                errorList.add(new String[]{"SequenceNumber_TYPE_ERR", "Sequence Number must be Integer", "SequenceNumber"});
                            }
                            else if(!validMessagesREp.findBySequenceNumber((Integer) SequenceNumber).isEmpty()){
                                errorList.add(new String[]{"SequenceNumber_DUP_ERR", "Sequence Number is duplicated", "SequenceNumber"});
                            }

                            if (DepositReference == null) {
                                errorList.add(new String[]{"DepositReference_NULL_ERR", "Deposit Reference cannot be null", "DepositReference"});
                            } else if (!(DepositReference instanceof String)) {
                                errorList.add(new String[]{"DepositReference_TYPE_ERR", "Deposit Reference must be String", "DepositReference"});
                            }

                        }
                        if(indicator1.equals("V")){
                            if (CashCentreCode == null) {
                                errorList.add(new String[]{"CashCentreCode_NULL_ERR", "Cash Centre Code cannot be null", "CashCentreCode"});
                            } else if (!(CashCentreCode instanceof String)) {
                                errorList.add(new String[]{"CashCenterType_TYPE_ERR", "Cash Centre Code must be String", "CashCentreCode"});
                            }
                            if (CashCenterType == null) {
                                errorList.add(new String[]{"CashCenterType_NULL_ERR", "Cash Center Type cannot be null", "CashCenterType"});
                            } else if (!(CashCenterType instanceof String)) {
                                errorList.add(new String[]{"CashCenterType_TYPE_ERR", "Cash Centre Code must be String", "CashCenterType"});
                            }



                        }

                        // If there are any errors, process them and return false
                        if (!errorList.isEmpty()) {
                            for (String[] error : errorList) {
                                updateReponseWithError(value.getId_message(), error[0], error[1], context, error[2]);
                            }
                            return false;
                        }

  }

        }}

        return true;
    }

    private void updateReponseWithError(int messageId, String errorCode, String errorMessage, ConstraintValidatorContext context,String message) {
        Reponse reponse = reponseService.findByid_message(messageId);
        reponse.setStatus(0);
        reponse.setCode(reponse.getCode() != null ? reponse.getCode() + "/" + errorCode : errorCode);
        reponserep.save(reponse);
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode(message)
                .addConstraintViolation();
    }
}
