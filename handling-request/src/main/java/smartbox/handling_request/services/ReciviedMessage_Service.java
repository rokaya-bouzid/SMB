package smartbox.handling_request.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import smartbox.handling_request.models.ReciviedMessage;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.ValidMessages;
import smartbox.handling_request.producer.KafkaJsonProducer;
import smartbox.handling_request.repositories.ReciviedMessage_Rep;

import java.util.*;

@Service
@Validated
public class ReciviedMessage_Service {

    @Autowired
    ReciviedMessage_Rep reciviedMessageRep;
    @Autowired
    ValidMessageService validMessageService;

    private final KafkaJsonProducer kafkaJsonProducer;

    public ReciviedMessage_Service(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    public ReciviedMessage saveMessage(Recivied_messageRequest reciviedMessageRequest) {
        ReciviedMessage reciviedMessage = new ReciviedMessage();
        reciviedMessage.setMessageType(reciviedMessageRequest.getMessageType() != null ? reciviedMessageRequest.getMessageType().toString() : null);
        reciviedMessage.setSequenceNumber(reciviedMessageRequest.getSequenceNumber()!= null ? reciviedMessageRequest.getSequenceNumber().toString() : null );
        reciviedMessage.setDepositReference(reciviedMessageRequest.getDepositReference()!= null ? reciviedMessageRequest.getDepositReference().toString() : null  );
        reciviedMessage.setMerchantNumber( reciviedMessageRequest.getMerchantNumber() != null ? reciviedMessageRequest.getMerchantNumber().toString() : null );
        reciviedMessage.setBagNumber(reciviedMessageRequest.getBagNumber() != null ? reciviedMessageRequest.getBagNumber().toString() : null);
        reciviedMessage.setDeviceNumber(reciviedMessageRequest.getDeviceNumber() != null ? reciviedMessageRequest.getDeviceNumber().toString() : null);
        reciviedMessage.setTransactionId(reciviedMessageRequest.getTransactionId() != null ? reciviedMessageRequest.getTransactionId().toString() : null);
        reciviedMessage.setContainerType(reciviedMessageRequest.getContainerType() != null ? reciviedMessageRequest.getContainerType().toString() : null);
        reciviedMessage.setTransmissionDate(reciviedMessageRequest.getTransmissionDate() != null ? reciviedMessageRequest.getTransmissionDate().toString() : null);
        reciviedMessage.setCanisterNumber(reciviedMessageRequest.getCanisterNumber() != null ? reciviedMessageRequest.getCanisterNumber().toString() : null);
        reciviedMessage.setCurrency(reciviedMessageRequest.getCurrency() != null ? reciviedMessageRequest.getCurrency().toString() : null);
        reciviedMessage.setCashCentreType(reciviedMessageRequest.getCashCentreType() != null ? reciviedMessageRequest.getCashCentreType().toString() : null);
        reciviedMessage.setCashCentreCode(reciviedMessageRequest.getCashCentreCode() != null ? reciviedMessageRequest.getCashCentreCode().toString() : null);
        reciviedMessage.setTotalAmount(reciviedMessageRequest.getTotalAmount() != null ? reciviedMessageRequest.getTotalAmount().toString() : null);
        reciviedMessage.setTotalNotes(reciviedMessageRequest.getTotalNotes() != null ? reciviedMessageRequest.getTotalNotes().toString() : null);
        reciviedMessage.setTotalCoins(reciviedMessageRequest.getTotalCoins() != null ? reciviedMessageRequest.getTotalCoins().toString() : null);
        reciviedMessage.setDenomination1(reciviedMessageRequest.getDenomination1() != null ? reciviedMessageRequest.getDenomination1().toString() : null);
        reciviedMessage.setDenomination2(reciviedMessageRequest.getDenomination2() != null ? reciviedMessageRequest.getDenomination2().toString() : null);
        reciviedMessage.setDenomination3(reciviedMessageRequest.getDenomination3() != null ? reciviedMessageRequest.getDenomination3().toString() : null);
        reciviedMessage.setDenomination4(reciviedMessageRequest.getDenomination4() != null ? reciviedMessageRequest.getDenomination4().toString() : null);
        reciviedMessage.setDenomination5(reciviedMessageRequest.getDenomination5() != null ? reciviedMessageRequest.getDenomination5().toString() : null);
        reciviedMessage.setDenomination6(reciviedMessageRequest.getDenomination6() != null ? reciviedMessageRequest.getDenomination6().toString() : null);
        reciviedMessage.setDenomination7(reciviedMessageRequest.getDenomination7() != null ? reciviedMessageRequest.getDenomination7().toString() : null);
        reciviedMessage.setDenomination8(reciviedMessageRequest.getDenomination8() != null ? reciviedMessageRequest.getDenomination8().toString() : null);
        reciviedMessage.setDenomination9(reciviedMessageRequest.getDenomination9() != null ? reciviedMessageRequest.getDenomination9().toString() : null);
        reciviedMessage.setDenomination10(reciviedMessageRequest.getDenomination10() != null ? reciviedMessageRequest.getDenomination10().toString() : null);
        reciviedMessage.setDenomination11(reciviedMessageRequest.getDenomination11() != null ? reciviedMessageRequest.getDenomination11().toString() : null);
        reciviedMessage.setDenomination12(reciviedMessageRequest.getDenomination12() != null ? reciviedMessageRequest.getDenomination12().toString() : null);
        reciviedMessage.setDenomination13(reciviedMessageRequest.getDenomination13() != null ? reciviedMessageRequest.getDenomination13().toString() : null);
        reciviedMessage.setDenomination14(reciviedMessageRequest.getDenomination14() != null ? reciviedMessageRequest.getDenomination14().toString() : null);
        reciviedMessage.setDenomination15(reciviedMessageRequest.getDenomination15() != null ? reciviedMessageRequest.getDenomination15().toString() : null);
        reciviedMessage.setStatus(reciviedMessageRequest.getStatus() != null ? reciviedMessageRequest.getStatus().toString() : null);


        reciviedMessageRep.save(reciviedMessage);
        return reciviedMessage;
    }


    public ResponseEntity<?> validation(@Valid Recivied_messageRequest message ) throws Exception {
        ValidMessages messageValid=validMessageService.SaveValidMessage(message);
        kafkaJsonProducer.sendMessage(messageValid);
        return new ResponseEntity<ValidMessages>(messageValid, HttpStatus.CREATED);

    }


}
