package smartbox.integrity_checks.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.time.LocalDateTime;
import java.util.Date;
@Data

public class ValidMessages {
    private Integer transactionId;
    private String messageType;
    private String bagNumber;
    private String deviceNumber;
    private Integer merchantNumber;
    private String containerType;
    private Integer sequenceNumber;
    private String depositReference;
    private String transmissionDate;
    private Integer canisterNumber;
    private String currency;
    private String cashCentreType;
    private String cashCentreCode;
    private Integer totalAmount;
    private Integer totalNotes;
    private Integer totalCoins;
    private Integer denomination1;
    private Integer denomination2;
    private Integer denomination3;
    private Integer denomination4;
    private Integer denomination5;
    private Integer denomination6;
    private Integer denomination7;
    private Integer denomination8;
    private Integer denomination9;
    private Integer denomination10;
    private Integer denomination11;
    private Integer denomination12;
    private Integer denomination13;
    private Integer denomination14;
    private Integer denomination15;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
}
