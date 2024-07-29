package smartbox.stockage.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Transaction {

    @Id
    @Column(length = 10)
    private String transactionId;

    @Column(length = 15)
    private String merchantNumber;

    @Column(length = 15)
    private String deviceNumber;

    @Column(length = 14)
    private String bagNumber;

    @Column(length = 1)
    private String containerType;

    @Column(length = 4)
    private String sequenceNumber;

    @Column(length = 20)
    private String depositReference;

    private Date transmissionDate;

    @Column(length = 6)
    private String canisterNumber;

    @Column(length = 3)
    private String currency;

    private double totalAmount;

    private int totalNotes;

    private int totalCoins;

    private int denomination1;
    private int denomination2;
    private int denomination3;
    private int denomination4;
    private int denomination5;
    private int denomination6;
    private int denomination7;
    private int denomination8;
    private int denomination9;
    private int denomination10;
    private int denomination11;
    private int denomination12;
    private int denomination13;
    private int denomination14;
    private int denomination15;

    @Column(length = 1)
    private char settlementFlag;

    private Date dateCreate;

    private Date dateUpdate;
}
