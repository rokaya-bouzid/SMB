package SmartBox.MerchantMangement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Merchant {
    @Id
    private int merchantNumber;
    private String details;
    //peut etre enum mais on peut  le faire static pour le moment
    private  String status;///suspended,closed,deactivated



}
