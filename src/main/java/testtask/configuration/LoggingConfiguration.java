package testtask.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import testtask.Main;

@Configuration
public class LoggingConfiguration {

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(Main.class);
    }

}
