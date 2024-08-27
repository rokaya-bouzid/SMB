package SmartBox.MerchantMangement.Exceptions;


import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorMessage {
    private int statusCode;
    private String message;
    private Date timestampDate;

    public ErrorMessage(int statusCode, String message, Date date) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestampDate = date;
    }
}