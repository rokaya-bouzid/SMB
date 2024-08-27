package smartbox.handling_request.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.ValidMessages;

@Service
@RequiredArgsConstructor

    public class KafkaJsonProducer {

        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;

        @Autowired
        private ObjectMapper objectMapper;

        public void sendMessage(ValidMessages validMessages) throws JsonProcessingException {
            var json = objectMapper.writeValueAsString(validMessages);
            kafkaTemplate.send("rkia", json);
        }
    }


