package restservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public TransactionManager sessionFactory() {
        return com.arjuna.ats.jta.TransactionManager.transactionManager();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("ogm-mongodb");
    }

}
