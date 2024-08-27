package com.example.dropmessage.consumer;

import com.example.dropmessage.model.DropRequest;
import com.example.dropmessage.service.DropService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class Consumer {

    @Autowired
    private DropService dropService;
    @Autowired
    private ObjectMapper objectMapper;
    @KafkaListener(topics ="DropMessage",groupId = "handling")
    public void listen(String message) throws JsonMappingException, JsonProcessingException,Exception {

        log.info("Received  Drop message: {}", message);
        DropRequest dropRequest= objectMapper.readValue(message, DropRequest.class);
        log.info("Converted message to ValidMessages: {}",dropRequest);
        dropService.StorageDropMessage(dropRequest);




    }


}
