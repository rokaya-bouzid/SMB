package smartbox.handling_request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HandlingRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandlingRequestApplication.class, args);
	}

}
