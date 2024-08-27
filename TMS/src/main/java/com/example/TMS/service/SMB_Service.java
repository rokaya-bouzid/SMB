package com.example.TMS.service;

import com.example.TMS.Repo.SMB_Repo;
import com.example.TMS.model.SMB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SMB_Service {


    @Autowired
    SMB_Repo smbRepo;
    public Optional<SMB> findSMBbyID (String id){
        return smbRepo.findById(id);

    }
}
