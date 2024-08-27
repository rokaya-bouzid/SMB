package smartbox.handling_request.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smartbox.handling_request.models.Reponse;
@Repository
public interface ReponseRep extends JpaRepository<Reponse,Integer> {
    @Query("SELECT p FROM Reponse p WHERE p.reciviedMessage.id = :id")
    Reponse findByIdmessage(@Param("id") Integer id);

}