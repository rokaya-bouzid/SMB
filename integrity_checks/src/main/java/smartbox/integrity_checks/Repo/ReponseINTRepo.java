package smartbox.integrity_checks.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import smartbox.integrity_checks.models.ReponseIntegrityPhase;

public interface ReponseINTRepo extends JpaRepository<ReponseIntegrityPhase,Integer> {


}
