package smartbox.verification_message.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smartbox.verification_message.model.Verification;
@Repository
public interface VerficationRepo extends JpaRepository<Verification,String> {
}
