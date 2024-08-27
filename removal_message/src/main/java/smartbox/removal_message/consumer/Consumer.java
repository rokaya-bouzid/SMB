package smartbox.removal_message.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import smartbox.removal_message.model.RemovalRequest;
import smartbox.removal_message.service.RemovalService;

@Service
@Slf4j
public class Consumer {
  @Autowired
    RemovalService removalService;
    @Autowired
    private ObjectMapper objectMapper;
    @KafkaListener(topics ="RemovalMessage",groupId = "handling")
    public void listen(String message) throws JsonMappingException, JsonProcessingException,Exception {

        log.info("Received  Removal message: {}", message);
        RemovalRequest dropRequest= objectMapper.readValue(message, RemovalRequest.class);
        log.info("Converted message to ValidMessages: {}",dropRequest);
       removalService.StorageRemovalMessage(dropRequest);





    }


}
