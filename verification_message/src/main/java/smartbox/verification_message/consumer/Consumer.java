package smartbox.verification_message.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import smartbox.verification_message.model.VerificationRequest;
import smartbox.verification_message.service.VerificationService;


@Service
@Slf4j
public class Consumer {

    @Autowired
    private VerificationService verificationService;
    @Autowired
    private ObjectMapper objectMapper;
    @KafkaListener(topics ="VerificationMessage",groupId = "handling")
    public void listen(String message) throws JsonMappingException, JsonProcessingException,Exception {

        log.info("Received  Drop message: {}", message);
        VerificationRequest VerificationRequest= objectMapper.readValue(message, smartbox.verification_message.model.VerificationRequest.class);
        log.info("Converted message to ValidMessages: {}",VerificationRequest);
        verificationService.StorageVerficationMessage(VerificationRequest);




    }


}
