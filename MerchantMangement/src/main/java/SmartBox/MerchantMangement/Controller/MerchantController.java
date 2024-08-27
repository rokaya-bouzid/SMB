package SmartBox.MerchantMangement.Controller;

import SmartBox.MerchantMangement.model.Merchant;
import SmartBox.MerchantMangement.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MerchantController {
    @Autowired
    MerchantService merchantService;
    @GetMapping("/getMerchantByID")
    public Optional<Merchant> GetMerchant(@RequestParam int id){

    return merchantService.getMerchantByID(id);
}
}
