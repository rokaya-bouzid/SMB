package smartbox.integrity_checks.kafkaconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import smartbox.integrity_checks.Feign.MerchantInterface;
import smartbox.integrity_checks.Service.Integrity_checksService;
import smartbox.integrity_checks.models.ValidMessages;

@Service
@Slf4j
public class Consumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public Integrity_checksService integrityChecksService;
    @KafkaListener(topics ="rkia",groupId = "handling")
    public void listen(String message) throws JsonMappingException, JsonProcessingException,Exception {

            log.info("Received message: {}", message);
            ValidMessages validmessage = objectMapper.readValue(message, ValidMessages.class);
            log.info("Converted message to ValidMessages: {}", validmessage);
            integrityChecksService.validationOfMessage(validmessage);
            log.info("Message processed successfully");



    }


}
