package smartbox.integrity_checks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data

public class Merchant {

    private int merchantNumber;
    private String details;
    private  String status;
}
