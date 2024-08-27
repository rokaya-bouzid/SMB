package smartbox.integrity_checks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import smartbox.integrity_checks.Feign.MerchantInterface;
import smartbox.integrity_checks.models.Merchant;

import java.util.Optional;

@RestController

public class IntegrityController {
    @Autowired
    MerchantInterface merchantInterface;
}
