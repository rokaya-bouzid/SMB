package smartbox.handling_request.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import smartbox.handling_request.models.ReciviedMessage;
import smartbox.handling_request.models.Reponse;

public interface ReciviedMessage_Rep extends JpaRepository<ReciviedMessage,Integer> {

}
