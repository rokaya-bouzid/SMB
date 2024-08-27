package smartbox.handling_request.validator.ContainerType;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;
import smartbox.handling_request.services.ReponseService;

public class ContainerTypeValidator implements ConstraintValidator<ValidContainerType, Recivied_messageRequest> {

    @Autowired
    private ReponseService reponseService;

    @Autowired
    private ReponseRep reponserep;

    @Override
    public void initialize(ValidContainerType constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(Recivied_messageRequest value, ConstraintValidatorContext context) {
        Object containerType = value.getContainerType();
        Object totalNotesObj = value.getTotalNotes();
        Object totalCoinsObj = value.getTotalCoins();
        if ((containerType ==null)) {
            updateReponseWithError(value.getId_message(), "CONTAINER_TYPE_NULL_ERR", "Container Type cannot be null ", context,"ContainerType");
            return false;
        }else{
        if (!(containerType instanceof String)) {
            updateReponseWithError(value.getId_message(), "CONTAINER_TYPE_TYPE_ERR", "Container Type must be a String.", context,"ContainerType");
            return false;
        }else{

            String containerTypeStr = (String) containerType;
            if (!containerTypeStr.equals("N") && !containerTypeStr.equals("C") ) {
                updateReponseWithError(value.getId_message(), "CONTAINER_TYPE_INVALID_ERR", "Invalid container type. Only 'N' and 'C'  are  accepted.", context,"ContainerType");
                return false;
            }
        else{
            if (totalNotesObj ==null || totalCoinsObj==null) {
                updateReponseWithError(value.getId_message(), "Notes/Coins_NULL_ERR", "Total Notes and Total Coins cannot be null", context,"TotalNotes");
                return false;
            }else{
                if (!(totalNotesObj instanceof Integer) ||  !(totalCoinsObj instanceof Integer)) {
                    updateReponseWithError(value.getId_message(), "TOTAL_NOTES_TYPE_ERR", "Total notes  and Total coins must be an Integer.", context,"TotalNotes/TotalCoins");
                    return false;
                }
                else{
                    Integer totalNotes = (Integer) totalNotesObj;
                    Integer totalcoins = (Integer) totalCoinsObj;
                    if ( totalNotes < 0 || totalcoins < 0 ) {
                        updateReponseWithError(value.getId_message(), "TOTAL_NOTES/COINS_VALUE_ERR", "Total notes and coins must be a positive integer.", context,"TotalNotes/TotalCoins");
                        return false;
                    }else{

                        if(!(totalcoins==0)&& containerTypeStr.equals("N")){
                            updateReponseWithError(value.getId_message(), "TOTAL_coins_VALUE_ERR", "Total coins must be zero because the bag contains just notes", context,"TotalCoins");
                            return false;
                        }else{
                        if(!(totalNotes==0)&& containerTypeStr.equals("C")){
                            updateReponseWithError(value.getId_message(), "TOTAL_Notes_VALUE_ERR", "Total notes must be zero because the bag contains just notes", context,"TotalNotes");
                            return false;
                        }else{
                        if((totalcoins==0)&& containerTypeStr.equals("C")){
                            updateReponseWithError(value.getId_message(), "TOTAL_Coins_VALUE_ERR", "The total number of coins must be greater than zero", context,"TotalCoins");
                            return false;
                        }else{
                        if((totalNotes==0)&& containerTypeStr.equals("N")){
                            updateReponseWithError(value.getId_message(), "TOTAL_Notes_VALUE_ERR", "The total number of notes must be greater than zero", context,"TotalNotes");
                            return false;
                        }else{
                            Object Dnm1 = value.getDenomination1();
                            Object Dnm2 = value.getDenomination2();
                            Object Dnm3 = value.getDenomination3();
                            Object Dnm4= value.getDenomination4();
                            Object Dnm5 = value.getDenomination5();
                            Object Dnm6 = value.getDenomination6();
                            Object Dnm7 = value.getDenomination7();
                            Object Dnm8 = value.getDenomination8();
                            Object Dnm9  = value.getDenomination9();
                            Object Dnm10 = value.getDenomination10();
                            Object Dnm11 = value.getDenomination11();
                            Object Dnm12= value.getDenomination12();
                            Object Dnm13 = value.getDenomination13();
                            Object Dnm14 = value.getDenomination14();
                            Object Dnm15 = value.getDenomination15();
                            if(Dnm1==null || Dnm2==null || Dnm3==null || Dnm4==null || Dnm5==null || Dnm6==null || Dnm7==null || Dnm8==null||Dnm9==null|| Dnm10==null || Dnm11==null ||Dnm12==null ||Dnm13==null || Dnm14==null ||Dnm15==null ){
                                updateReponseWithError(value.getId_message(), "DNM_NULL_ERR", "Denominations must not be null.", context,"Donominations");
                                return false;
                            }
                            if(!( Dnm1 instanceof Integer) || !( Dnm2 instanceof Integer) |!( Dnm3 instanceof Integer) || !( Dnm4 instanceof Integer) || !( Dnm5 instanceof Integer)|| !( Dnm6 instanceof Integer)|| !( Dnm7 instanceof Integer) || !( Dnm8 instanceof Integer)||!( Dnm9 instanceof Integer)|| !( Dnm10 instanceof Integer)|| !( Dnm11 instanceof Integer) ||!( Dnm12 instanceof Integer) ||!( Dnm13 instanceof Integer) || !( Dnm14 instanceof Integer) ||!( Dnm15 instanceof Integer) ){
                                updateReponseWithError(value.getId_message(), "DNM_TYPE_ERR", "Denominations must be Integer.", context,"Donominations");
                                return false;
                            }// Retrieve and convert all denomination values to integers
                            Integer Donm1 = (Integer) value.getDenomination1();
                            Integer Donm2 = (Integer) value.getDenomination2();
                            Integer  Donm3 = (Integer) value.getDenomination3();
                            Integer  Donm4 = (Integer) value.getDenomination4();
                            Integer Donm5 = (Integer) value.getDenomination5();
                            Integer Donm6 = (Integer) value.getDenomination6();
                            Integer Donm7 = (Integer) Dnm7;
                            Integer Donm8 = (Integer) value.getDenomination8();
                            Integer Donm9 = (Integer) value.getDenomination9();
                            Integer Donm10 = (Integer) value.getDenomination10();
                            Integer Donm11 = (Integer) value.getDenomination11();
                            Integer Donm12 = (Integer) value.getDenomination12();
                            Integer Donm13 = (Integer) value.getDenomination13();
                            Integer Donm14 = (Integer) value.getDenomination14();
                            Integer Donm15 = (Integer) value.getDenomination15();


                            if(totalcoins!=0){
                                if(Donm7!=0 || Donm8!=0|| Donm9!=0 || Donm10!=0 || Donm11!=0|| Donm12!=0|| Donm13!=0 ||Donm14!=0 || Donm15!=0){
                                    updateReponseWithError(value.getId_message(), "DNM_ERR", "Denominations (7,8,9,10,11,12,13,14,15 ) must be Zero because bag contain just coins.", context,"Donominations");
                                    return false;
                                }
                            }

                            if(totalNotes!=0){
                                if(Donm1!=0 || Donm2!=0|| Donm3!=0 || Donm4!=0 || Donm5!=0|| Donm6!=0){
                                    updateReponseWithError(value.getId_message(), "DNM_ERR", "Denominations (1,2,3,4,5,6 ) must be Zero because bag contain just notes.", context,"Donominations");
                                    return false;
                                }
                            }}}}}}}

                    }

                }
            }
        }

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
