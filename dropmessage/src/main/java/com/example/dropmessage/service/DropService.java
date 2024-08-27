package com.example.dropmessage.service;

import com.example.dropmessage.Repository.DropRepo;
import com.example.dropmessage.model.Drop;
import com.example.dropmessage.model.DropRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class DropService {
    @Autowired
    DropRepo dropRepo;
    public void StorageDropMessage(DropRequest dropRequest){
        Drop dropmessage =new Drop();
        dropmessage.setBagNumber(dropRequest.getBagNumber() );
        dropmessage.setSequenceNumber(String.valueOf(dropRequest.getSequenceNumber()));
        dropmessage.setDepositReference(dropRequest.getDepositReference() );
        dropmessage.setMerchantNumber(String.valueOf(dropRequest .getMerchantNumber()));
        dropmessage.setDeviceNumber(dropRequest .getDeviceNumber() );
        dropmessage.setTransactionId(String.valueOf(dropRequest .getTransactionId()));
        dropmessage.setContainerType(dropRequest .getContainerType() );
        dropmessage.setTransmissionDate(dropRequest .getTransmissionDate());
        dropmessage.setCanisterNumber(String.valueOf(dropRequest .getCanisterNumber()));
        dropmessage.setCurrency(dropRequest .getCurrency() );
        dropmessage.setTotalAmount( dropRequest .getTotalAmount());
        dropmessage.setTotalNotes( dropRequest .getTotalNotes() );
        dropmessage.setTotalCoins( dropRequest .getTotalCoins());
        dropmessage.setDenomination1(dropRequest .getDenomination1() );
        dropmessage.setDenomination2(dropRequest .getDenomination2() );
        dropmessage.setDenomination3(dropRequest .getDenomination3() );
        dropmessage.setDenomination4(dropRequest .getDenomination4() );
        dropmessage.setDenomination5( dropRequest .getDenomination5() );
        dropmessage.setDenomination6( dropRequest .getDenomination6() );
        dropmessage.setDenomination7( dropRequest .getDenomination7() );
        dropmessage.setDenomination8( dropRequest .getDenomination8() );
        dropmessage.setDenomination9( dropRequest .getDenomination9() );
        dropmessage.setDenomination10( dropRequest .getDenomination10() );
        dropmessage.setDenomination11( dropRequest .getDenomination11() );
        dropmessage.setDenomination12( dropRequest .getDenomination12() );
        dropmessage.setDenomination13(dropRequest .getDenomination13());
        dropmessage.setDenomination14(dropRequest .getDenomination14() );
        dropmessage.setDenomination15(dropRequest .getDenomination15() );
       dropRepo.save(dropmessage);

    }
}
