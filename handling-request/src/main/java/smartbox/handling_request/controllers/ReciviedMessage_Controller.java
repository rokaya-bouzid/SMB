package smartbox.handling_request.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import smartbox.handling_request.models.ReciviedMessage;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.services.ReciviedMessage_Service;
import smartbox.handling_request.services.ReponseService;

@RestController
public class ReciviedMessage_Controller {
    @Autowired
    ReciviedMessage_Service reciviedMessageService;

    @Autowired
    ReponseService ReponseService;
    @RequestMapping(value = "/message_reception", method = RequestMethod.POST)
    public ResponseEntity<?> reception(@RequestBody Recivied_messageRequest message )throws Exception {
     ReciviedMessage rc = reciviedMessageService.saveMessage(message);
     message.setId_message(rc.getId());
        Reponse reponse= new Reponse();
        reponse.setReciviedMessage(rc);
        reponse.setStatus(1);
        ReponseService.saveReponse(reponse);
     return reciviedMessageService.validation(message);


    }
}
