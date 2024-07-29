package smartbox.nonfunctional_message.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping ("/message_reception")
    public String reception( ){

        return "yes";

    }
}
