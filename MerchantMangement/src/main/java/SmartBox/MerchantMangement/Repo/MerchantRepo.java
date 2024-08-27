package SmartBox.MerchantMangement.Repo;

import SmartBox.MerchantMangement.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant,Integer> {
}
