package smartbox.removal_message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartbox.removal_message.Repository.RemovalRepo;
import smartbox.removal_message.model.Removal;
import smartbox.removal_message.model.RemovalRequest;

import java.time.LocalDateTime;

@Service
public class RemovalService {
    @Autowired
    RemovalRepo removalRepo;
    public void StorageRemovalMessage(RemovalRequest removalRequest) {

        Removal removalMessage =new Removal();
        removalMessage.setBagNumber(removalRequest.getBagNumber() );
        removalMessage.setSequenceNumber(String.valueOf(removalRequest.getSequenceNumber()));
        removalMessage.setDepositReference(removalRequest.getDepositReference() );
        removalMessage.setDeviceNumber(removalRequest .getDeviceNumber() );
        removalMessage.setTransactionId(String.valueOf(removalRequest .getTransactionId()));
        removalMessage.setContainerType(removalRequest .getContainerType() );
        removalMessage.setTransmissionDate( removalRequest .getTransmissionDate());
        removalMessage.setCanisterNumber(String.valueOf(removalRequest .getCanisterNumber()));
        removalMessage.setCurrency(removalRequest .getCurrency() );
        removalMessage.setTotalAmount( removalRequest .getTotalAmount());
        removalMessage.setTotalNotes( removalRequest .getTotalNotes() );
        removalMessage.setTotalCoins( removalRequest .getTotalCoins());
        removalMessage.setDenomination1(removalRequest .getDenomination1() );
        removalMessage.setDenomination2(removalRequest .getDenomination2() );
        removalMessage.setDenomination3(removalRequest .getDenomination3() );
        removalMessage.setDenomination4(removalRequest .getDenomination4() );
        removalMessage.setDenomination5( removalRequest .getDenomination5() );
        removalMessage.setDenomination6( removalRequest .getDenomination6() );
        removalMessage.setDenomination7( removalRequest .getDenomination7() );
        removalMessage.setDenomination8( removalRequest .getDenomination8() );
        removalMessage.setDenomination9( removalRequest .getDenomination9() );
        removalMessage.setDenomination10( removalRequest .getDenomination10() );
        removalMessage.setDenomination11( removalRequest .getDenomination11() );
        removalMessage.setDenomination12( removalRequest .getDenomination12() );
        removalMessage.setDenomination13(removalRequest .getDenomination13());
        removalMessage.setDenomination14(removalRequest .getDenomination14() );
        removalMessage.setDenomination15(removalRequest .getDenomination15() );
        removalRepo.save(removalMessage);
    }
}
