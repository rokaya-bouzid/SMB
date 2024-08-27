package smartbox.integrity_checks.models;

import lombok.Data;

@Data
public class SMB {

    private int SMB_Number;

    private int Merchant_Number;
    //peut etre enum
    private String status;
}
