package smartbox.integrity_checks.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smartbox.integrity_checks.models.MessageAfterIntegrity_check;

import java.util.List;

@Repository
public interface MessageAfterIntegrityRepo extends JpaRepository<MessageAfterIntegrity_check, Integer> {

    @Query("SELECT M FROM MessageAfterIntegrity_check M WHERE M.bagNumber = :bagNumber AND M.messageType = :messageType")
    List<MessageAfterIntegrity_check> findDrops(@Param("bagNumber") String bagNumber, @Param("messageType") String messageType);
}
