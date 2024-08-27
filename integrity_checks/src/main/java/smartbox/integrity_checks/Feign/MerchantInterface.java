package smartbox.integrity_checks.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import smartbox.integrity_checks.models.Merchant;

import java.util.Optional;

@FeignClient("MERCHANTMANGEMENT")
public interface MerchantInterface {
    @GetMapping("/getMerchantByID")
    public Optional<Merchant> GetMerchant(@RequestParam int id);

}
