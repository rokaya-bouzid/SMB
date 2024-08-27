package smartbox.verification_message.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Verification {
    @Id
    private String transactionId;
    private String deviceNumber;
    private String bagNumber;
    private String containerType;
    private String transmissionDate;
    private String canisterNumber;
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
    private char settlementFlag;

    @CreatedDate
    private LocalDateTime dateCreate;

    @LastModifiedDate
    private LocalDateTime dateUpdate;
}
