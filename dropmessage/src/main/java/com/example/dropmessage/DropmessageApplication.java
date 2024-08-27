package com.example.dropmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DropmessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DropmessageApplication.class, args);
	}

}
