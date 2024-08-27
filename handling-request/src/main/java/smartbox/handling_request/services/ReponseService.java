package smartbox.handling_request.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartbox.handling_request.models.ReciviedMessage;
import smartbox.handling_request.models.Recivied_messageRequest;
import smartbox.handling_request.models.Reponse;
import smartbox.handling_request.repositories.ReponseRep;

@Service
public class ReponseService {
    @Autowired
    ReponseRep reponseRep;
    public void saveReponse(Reponse rp){


        reponseRep.save(rp);
    }
    public Reponse findByid_message(int id_message ){
        return  reponseRep.findByIdmessage(id_message);
    }









}
