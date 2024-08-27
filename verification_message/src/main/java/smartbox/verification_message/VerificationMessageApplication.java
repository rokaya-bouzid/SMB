package smartbox.verification_message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VerificationMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerificationMessageApplication.class, args);
	}

}
