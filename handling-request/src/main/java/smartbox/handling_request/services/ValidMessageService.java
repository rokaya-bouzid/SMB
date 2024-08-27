package smartbox.handling_request.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartbox.handling_request.models.ReciviedMessage;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.ValidMessages;
import smartbox.handling_request.repositories.ValidMessagesREp;

import java.util.Date;

@Service
public class ValidMessageService {
    @Autowired
    private ValidMessagesREp validMessagesREp;
    public Boolean findMessageByTransactionId(Integer TansactionID){
         ValidMessages VM=validMessagesREp.findByIdTransaction(TansactionID);
         if(VM!=null){
             return true;
         }
         return false;
    }
    public ValidMessages SaveValidMessage(Recivied_messageRequest reciviedMessageRequest){
        ValidMessages ValidMessage = new ValidMessages();
        ValidMessage.setMessageType((String) reciviedMessageRequest.getMessageType() );
        ValidMessage.setBagNumber((String) reciviedMessageRequest.getBagNumber() );
        ValidMessage.setSequenceNumber((Integer) reciviedMessageRequest.getSequenceNumber() );

        ValidMessage.setDepositReference((String) reciviedMessageRequest.getDepositReference() );
        ValidMessage.setMerchantNumber((Integer) reciviedMessageRequest.getMerchantNumber() );
        ValidMessage.setDeviceNumber((String) reciviedMessageRequest.getDeviceNumber() );
        ValidMessage.setTransactionId((Integer) reciviedMessageRequest.getTransactionId());
        ValidMessage.setContainerType((String) reciviedMessageRequest.getContainerType() );
        ValidMessage.setTransmissionDate((String) reciviedMessageRequest.getTransmissionDate() );
        ValidMessage.setCanisterNumber((Integer) reciviedMessageRequest.getCanisterNumber() );
        ValidMessage.setCurrency((String) reciviedMessageRequest.getCurrency() );
        ValidMessage.setCashCentreType((String) reciviedMessageRequest.getCashCentreType() );
        ValidMessage.setCashCentreCode((String) reciviedMessageRequest.getCashCentreCode());
        ValidMessage.setTotalAmount((Integer) reciviedMessageRequest.getTotalAmount());
        ValidMessage.setTotalNotes((Integer) reciviedMessageRequest.getTotalNotes() );
        ValidMessage.setTotalCoins((Integer) reciviedMessageRequest.getTotalCoins());
        ValidMessage.setDenomination1((Integer) reciviedMessageRequest.getDenomination1() );
        ValidMessage.setDenomination2((Integer) reciviedMessageRequest.getDenomination2() );
        ValidMessage.setDenomination3((Integer) reciviedMessageRequest.getDenomination3() );
        ValidMessage.setDenomination4((Integer) reciviedMessageRequest.getDenomination4() );
        ValidMessage.setDenomination5((Integer) reciviedMessageRequest.getDenomination5() );
        ValidMessage.setDenomination6((Integer) reciviedMessageRequest.getDenomination6() );
        ValidMessage.setDenomination7((Integer) reciviedMessageRequest.getDenomination7() );
        ValidMessage.setDenomination8((Integer) reciviedMessageRequest.getDenomination8() );
        ValidMessage.setDenomination9((Integer) reciviedMessageRequest.getDenomination9() );
        ValidMessage.setDenomination10((Integer) reciviedMessageRequest.getDenomination10() );
        ValidMessage.setDenomination11((Integer) reciviedMessageRequest.getDenomination11() );
        ValidMessage.setDenomination12((Integer) reciviedMessageRequest.getDenomination12() );
        ValidMessage.setDenomination13((Integer)reciviedMessageRequest.getDenomination13());
        ValidMessage.setDenomination14((Integer)reciviedMessageRequest.getDenomination14() );
        ValidMessage.setDenomination15((Integer)reciviedMessageRequest.getDenomination15() );


        return validMessagesREp.save(ValidMessage);

    }
}
