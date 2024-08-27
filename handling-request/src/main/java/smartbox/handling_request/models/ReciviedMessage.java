package smartbox.handling_request.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ReciviedMessage {
    @Id
    @GeneratedValue
    private int id;
    private String messageType; // Remplacé par String
    private String bagNumber; // Remplacé par String
    private String deviceNumber; // Remplacé par String
    private String merchantNumber; // Remplacé par String
    private String transactionId; // Remplacé par String
    private String containerType; // Remplacé par String
    private String sequenceNumber; // Remplacé par String
    private String depositReference; // Remplacé par String
    private String transmissionDate; // Remplacé par String
    private String canisterNumber; // Remplacé par String
    private String currency; // Remplacé par String
    private String cashCentreType; // Remplacé par String
    private String cashCentreCode; // Remplacé par String
    private String totalAmount; // Remplacé par String
    private String totalNotes; // Remplacé par String
    private String totalCoins; // Remplacé par String
    private String denomination1; // Remplacé par String
    private String denomination2; // Remplacé par String
    private String denomination3; // Remplacé par String
    private String denomination4; // Remplacé par String
    private String denomination5; // Remplacé par String
    private String denomination6; // Remplacé par String
    private String denomination7; // Remplacé par String
    private String denomination8; // Remplacé par String
    private String denomination9; // Remplacé par String
    private String denomination10; // Remplacé par String
    private String denomination11; // Remplacé par String
    private String denomination12; // Remplacé par String
    private String denomination13; // Remplacé par String
    private String denomination14; // Remplacé par String
    private String denomination15; // Remplacé par Object
    private String Status; // Remplacé par Object
    @OneToOne(mappedBy = "reciviedMessage")
    private Reponse reponse;
    @CreatedDate
    private LocalDateTime dateCreate;
    @LastModifiedDate
    private LocalDateTime dateUpdate;
}
