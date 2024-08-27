package SmartBox.MerchantMangement.Exceptions;

import lombok.Data;

@Data
public class ExceptionEntityNotFound extends RuntimeException {
    public ExceptionEntityNotFound(){}
    public ExceptionEntityNotFound(String message){
        super(message);
    }

}

