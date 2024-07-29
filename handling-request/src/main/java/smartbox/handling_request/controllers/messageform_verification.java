package smartbox.handling_request.controllers;

import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class messageform_verification {
    @GetMapping ("/message_reception")
    public String reception( ){

        return "yes";

    }

}
