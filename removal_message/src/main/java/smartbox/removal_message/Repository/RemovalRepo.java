package smartbox.removal_message.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smartbox.removal_message.model.Removal;
@Repository
public interface RemovalRepo extends JpaRepository<Removal,String> {
}
