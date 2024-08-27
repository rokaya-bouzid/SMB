package smartbox.handling_request.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Reponse {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recivied_message_id", referencedColumnName = "id")
    private ReciviedMessage reciviedMessage;
    private int status;
    private String code;
    @CreatedDate
    private LocalDateTime dateCreate;
    @LastModifiedDate
    private LocalDateTime dateUpdate;

}
