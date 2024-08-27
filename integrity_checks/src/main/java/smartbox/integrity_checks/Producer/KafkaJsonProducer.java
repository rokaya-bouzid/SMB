package smartbox.integrity_checks.Producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import smartbox.integrity_checks.models.MessageAfterIntegrity_check;
import smartbox.integrity_checks.models.ValidMessages;

@Service
@RequiredArgsConstructor

public class KafkaJsonProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessageDrop(ValidMessages validMessages) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(validMessages);
        kafkaTemplate.send("DropMessage", json);
    }
    public void sendMessageRemoval(ValidMessages validMessages) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(validMessages);
        kafkaTemplate.send("RemovalMessage", json);
    }
    public void sendMessageVerification(ValidMessages validMessages) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(validMessages);
        kafkaTemplate.send("VerificationMessage", json);
    }
}


