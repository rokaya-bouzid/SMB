package smartbox.integrity_checks.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartbox.integrity_checks.Feign.MerchantInterface;
import smartbox.integrity_checks.Feign.SMBInterface;
import smartbox.integrity_checks.Producer.KafkaJsonProducer;
import smartbox.integrity_checks.Repo.MessageAfterIntegrityRepo;
import smartbox.integrity_checks.Repo.ReponseINTRepo;
import smartbox.integrity_checks.models.*;

import java.util.List;
import java.util.Optional;

@Service

public class Integrity_checksService {
    private static final Logger log = LoggerFactory.getLogger(Integrity_checksService.class);
    @Autowired
    MerchantInterface merchantInterface;
    @Autowired
    KafkaJsonProducer kafkaJsonProducer;
    @Autowired
    SMBInterface smbInterface;
    @Autowired
    ReponseINTRepo reponseINTRepo;

    @Autowired
    MessageAfterIntegrityRepo messageAfterIntegrityRepo;
    public boolean validationOfMessage( ValidMessages validMessages)throws Exception{
        ReponseIntegrityPhase reponse= new ReponseIntegrityPhase();
        stockageReponse1(validMessages,reponse);
        Optional<Merchant> merchants=merchantInterface.GetMerchant(validMessages.getMerchantNumber());
        Optional<SMB> Smb=smbInterface.GetSMBbyID(validMessages.getDeviceNumber());
       //Drop
        if(validMessages.getMessageType().equals("D")){
           if(!ValidMerchantNumber(merchants)){
               stockageReponse2("MNF",reponse);
               return false;
           }
           if(!DeviceNotValid(Smb)){
               stockageReponse2("IND",reponse); ///Invalid Device
               return false;
           }
           if(!DeviceNotLinkedToMerchant(Smb,validMessages.getMerchantNumber()))
           {
               stockageReponse2("MAP",reponse); ///Invalid Device
               return false;
           }
            StockValidMessage(validMessages);
            kafkaJsonProducer.sendMessageDrop(validMessages);
        }
        //Removal
        else if (validMessages.getMessageType().equals("R")){
            if(!DeviceNotValid(Smb)){
                stockageReponse2("IND",reponse); ///Invalid Device
                return false;
            }
            StockValidMessage(validMessages);
            kafkaJsonProducer.sendMessageRemoval(validMessages);

        }
        //verification
        else {
            if(!DeviceNotValid(Smb)){
                stockageReponse2("IND",reponse); ///Invalid Device
                return false;
            }
            if(!VerificationMSG_withoutDrops(validMessages)){
                stockageReponse2("NDP",reponse);

            }
            StockValidMessage(validMessages);
            kafkaJsonProducer.sendMessageVerification(validMessages);
        }


        return true;
    }
    public Boolean ValidMerchantNumber(Optional<Merchant> merchants ){
       if( merchants.isEmpty()){
           log.info("Merchant number is not present. ");
           return false;
       }
        Merchant merchant = merchants.get();
        String status = merchant.getStatus();
        if(status!=null){
         if(status.equals("suspended")||status.equals("closed")||status.equals("deactivated")){
            return false;
        }}
       return true;
    }
    public Boolean DeviceNotValid(Optional<SMB> Smb){
        if(Smb.isEmpty()){
            log.info("SMB number is not present. ");
            return false;
        }
        SMB smb = Smb.get();
        String status = smb.getStatus();
        if(status!=null){
            if(status.equals("INACTIVE")||status.equals("MAINTENANCE")) {
                return false;
            }}
       return true;
    }
public Boolean VerificationMSG_withoutDrops(ValidMessages validMessages) {
    List<MessageAfterIntegrity_check> Drops = messageAfterIntegrityRepo.findDrops(validMessages.getBagNumber(), validMessages.getMessageType());
    if (Drops.isEmpty()) {
        return false;
    }
    return true;
}
    public  Boolean DeviceNotLinkedToMerchant(Optional<SMB> Smb, int merchantNumber ){
        SMB smb = Smb.get();
        if(smb.getMerchant_Number()!=merchantNumber){

            log.info("SMB number is not present. ");
            return  false;
        }
        return true;
    }
    public void stockageReponse1(ValidMessages validmessage, ReponseIntegrityPhase reponse){
        reponse.setMessageType(validmessage.getMessageType() );
        reponse.setBagNumber( validmessage.getBagNumber() );
        reponse.setSequenceNumber( validmessage.getSequenceNumber() );
        reponse.setDepositReference(validmessage.getDepositReference() );
        reponse.setMerchantNumber( validmessage.getMerchantNumber() );
        reponse.setDeviceNumber(validmessage.getDeviceNumber() );
        reponse.setTransactionId( validmessage.getTransactionId());
        reponse.setContainerType(validmessage.getContainerType() );
        reponse.setTransmissionDate(validmessage.getTransmissionDate() );
        reponse.setCanisterNumber(validmessage.getCanisterNumber() );
        reponse.setCurrency(validmessage.getCurrency() );
        reponse.setCashCentreType(validmessage.getCashCentreType() );
        reponse.setCashCentreCode(validmessage.getCashCentreCode());
        reponse.setTotalAmount( validmessage.getTotalAmount());
        reponse.setTotalNotes( validmessage.getTotalNotes() );
        reponse.setTotalCoins( validmessage.getTotalCoins());
        reponse.setDenomination1( validmessage.getDenomination1() );
        reponse.setDenomination2( validmessage.getDenomination2() );
        reponse.setDenomination3( validmessage.getDenomination3() );
        reponse.setDenomination4(validmessage.getDenomination4() );
        reponse.setDenomination5( validmessage.getDenomination5() );
        reponse.setDenomination6( validmessage.getDenomination6() );
        reponse.setDenomination7( validmessage.getDenomination7() );
        reponse.setDenomination8( validmessage.getDenomination8() );
        reponse.setDenomination9( validmessage.getDenomination9() );
        reponse.setDenomination10( validmessage.getDenomination10() );
        reponse.setDenomination11( validmessage.getDenomination11() );
        reponse.setDenomination12( validmessage.getDenomination12() );
        reponse.setDenomination13(validmessage.getDenomination13());
        reponse.setDenomination14(validmessage.getDenomination14() );
        reponse.setDenomination15(validmessage.getDenomination15() );
        reponse.setStatus(1);
        reponseINTRepo.save(reponse);

    }
    public void stockageReponse2(String code, ReponseIntegrityPhase reponse){

        reponse.setStatus(0);
        if(reponse.getCode()!=null){
            reponse.setCode(reponse.getCode()+"\\"+code);
        }else{
        reponse.setCode(code);}
        reponseINTRepo.save(reponse);
    }
    public void StockValidMessage(ValidMessages validmessage){
        MessageAfterIntegrity_check message=new MessageAfterIntegrity_check();
        message.setMessageType(validmessage.getMessageType() );
        message.setBagNumber( validmessage.getBagNumber() );
        message.setSequenceNumber( validmessage.getSequenceNumber() );
        message.setDepositReference(validmessage.getDepositReference() );
        message.setMerchantNumber( validmessage.getMerchantNumber() );
        message.setDeviceNumber(validmessage.getDeviceNumber() );
        message.setTransactionId( validmessage.getTransactionId());
        message.setContainerType(validmessage.getContainerType() );
        message.setTransmissionDate(validmessage.getTransmissionDate() );
        message.setCanisterNumber(validmessage.getCanisterNumber() );
        message.setCurrency(validmessage.getCurrency() );
        message.setCashCentreType(validmessage.getCashCentreType() );
        message.setCashCentreCode(validmessage.getCashCentreCode());
        message.setTotalAmount( validmessage.getTotalAmount());
        message.setTotalNotes( validmessage.getTotalNotes() );
        message.setTotalCoins( validmessage.getTotalCoins());
        message.setDenomination1( validmessage.getDenomination1() );
        message.setDenomination2( validmessage.getDenomination2() );
        message.setDenomination3( validmessage.getDenomination3() );
        message.setDenomination4(validmessage.getDenomination4() );
        message.setDenomination5( validmessage.getDenomination5() );
        message.setDenomination6( validmessage.getDenomination6() );
        message.setDenomination7( validmessage.getDenomination7() );
        message.setDenomination8( validmessage.getDenomination8() );
        message.setDenomination9( validmessage.getDenomination9() );
        message.setDenomination10( validmessage.getDenomination10() );
        message.setDenomination11( validmessage.getDenomination11() );
        message.setDenomination12( validmessage.getDenomination12() );
        message.setDenomination13(validmessage.getDenomination13());
        message.setDenomination14(validmessage.getDenomination14() );
        message.setDenomination15(validmessage.getDenomination15() );
        messageAfterIntegrityRepo.save(message);

    }


}
