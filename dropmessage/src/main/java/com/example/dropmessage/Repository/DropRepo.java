package com.example.dropmessage.Repository;

import com.example.dropmessage.model.Drop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropRepo extends JpaRepository<Drop,String> {

}
