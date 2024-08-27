package com.example.TMS.Repo;

import com.example.TMS.model.SMB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public   interface SMB_Repo extends JpaRepository<SMB,String > {

}

