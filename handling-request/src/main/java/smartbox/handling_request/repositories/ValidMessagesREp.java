package smartbox.handling_request.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.models.ValidMessages;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValidMessagesREp extends JpaRepository<ValidMessages,Integer> {
    @Query("SELECT v FROM ValidMessages v WHERE v.transactionId= :id")
    ValidMessages findByIdTransaction(@Param("id") Integer id);
    @Query("SELECT v FROM ValidMessages v WHERE v.sequenceNumber= :SquenceNumber")
    List<ValidMessages> findBySequenceNumber(@Param("SquenceNumber") Integer SquenceNumber);
    @Query("SELECT v FROM ValidMessages v WHERE v.transmissionDate= :transmissionDate")
    List<ValidMessages> findByTransmissionDate(@Param("transmissionDate") String transmissionDate);
}
