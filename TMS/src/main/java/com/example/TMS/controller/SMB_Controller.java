package com.example.TMS.controller;

import com.example.TMS.model.SMB;
import com.example.TMS.service.SMB_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SMB_Controller {
    @Autowired
    SMB_Service smbService;
    @GetMapping("/getSMBbyID")
    public Optional<SMB> GetSMBbyID(@RequestParam String id){
        return   smbService.findSMBbyID(id);

    }
}
