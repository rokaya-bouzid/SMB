package smartbox.handling_request.models;

import lombok.Data;
import smartbox.handling_request.validator.BagNumber.ValidBgNumber;
import smartbox.handling_request.validator.CanisterNumber.ValidCanisterNumber;
import smartbox.handling_request.validator.ContainerType.ValidContainerType;
import smartbox.handling_request.validator.DeviceNumber.ValidDeviceNumber;
import smartbox.handling_request.validator.Status.ValidStatus;
import smartbox.handling_request.validator.Transaction_Id.ValidTransactionId;
import smartbox.handling_request.validator.TransmissionDate.ValidTransmissionDate;
import smartbox.handling_request.validator.MessageType.ValidMessageType;
import smartbox.handling_request.validator.currency.Validcurrency;
import smartbox.handling_request.validator.totalAmount.ValidTotalAmount;


@Data
@ValidTransactionId
@ValidMessageType
@ValidDeviceNumber
@ValidBgNumber
@ValidContainerType
@ValidCanisterNumber
@ValidTransmissionDate
@ValidTotalAmount
@Validcurrency
@ValidStatus
public class Recivied_messageRequest {

    private Object messageType;
    private Object bagNumber;
    private Object deviceNumber;
    private Object merchantNumber;
    private Object transactionId;
    private Object containerType;
    private Object sequenceNumber;
    private Object depositReference;
    private Object transmissionDate;
    private Object canisterNumber;
    private Object currency;
    private Object cashCentreType;
    private Object cashCentreCode;
    private Object totalAmount;
    private Object totalNotes;
    private Object totalCoins;
    private Object denomination1;
    private Object denomination2;
    private Object denomination3;
    private Object denomination4;
    private Object denomination5;
    private Object denomination6;
    private Object denomination7;
    private Object denomination8;
    private Object denomination9;
    private Object denomination10;
    private Object denomination11;
    private Object denomination12;
    private Object denomination13;
    private Object denomination14;
    private Object denomination15;
    private int id_message;
    private Object Status;

}
