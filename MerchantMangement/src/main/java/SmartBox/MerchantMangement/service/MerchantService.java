package SmartBox.MerchantMangement.service;

import SmartBox.MerchantMangement.Repo.MerchantRepo;
import SmartBox.MerchantMangement.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantService {
    @Autowired
     public MerchantRepo merchantRepo;

    public MerchantService(MerchantRepo merchantRepo) {
        this.merchantRepo = merchantRepo;
    }


    public Optional<Merchant> getMerchantByID (int id){

       Optional<Merchant> merchant= merchantRepo.findById(id);

       return merchant;

    }

}
