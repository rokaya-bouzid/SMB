package smartbox.integrity_checks.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration

public class KafkaTopicConfig {

    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

@Bean
public NewTopic DropMessage()
{
    return TopicBuilder.name("DropMessage")

            .build();
}

    @Bean
    public NewTopic RemovalMessage()
    {
        return TopicBuilder.name("RemovalMessage")
                .build();
    }

    @Bean
    public NewTopic VerificationMessage()
    {
        return TopicBuilder.name("VerificationMessage")
                .build();
    }

}