package bank;

import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return argz -> {
            userRepository.save(new User("John", "Doe", 1234));
            userRepository.save(new User("Jane", "Does", 5678));

            userRepository.findAll().forEach(user -> log.info("Preloaded " + user));

        };
    }
}
