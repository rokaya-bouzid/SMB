package com.example.TMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SMB {
    @Id
    private String SMB_Number;

    private int Merchant_Number;
    //peut etre enum
    private String status;
}
