package smartbox.handling_request.validator.DeviceNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;

public class DeviceNumberValidator implements ConstraintValidator<ValidDeviceNumber, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;

    @Override
    public void initialize(ValidDeviceNumber constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object deviceNumber = value.getDeviceNumber();
        if (deviceNumber == null ) {
            updateReponseWithError(value.getId_message(), "DEV_NUM_NULL_EMPTY_ERR", "Device number cannot be null or empty.", context);
            return false;
        }else{
        if (!(deviceNumber instanceof String)) {
            updateReponseWithError(value.getId_message(), "DEV_NUM_STR_ERR", "Device number must be a String.", context);
            return false;
        }else {

            String deviceNumberStr = (String) deviceNumber;

            if (!deviceNumberStr.matches("\\d{6}")) {
                updateReponseWithError(value.getId_message(), "DEV_NUM_FORMAT_ERR", "Device number should contain six digits.", context);
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
                .addPropertyNode("Device number")
                .addConstraintViolation();
    }
}
