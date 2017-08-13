package uk.me.krupa.kruton.facts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"uk.me.krupa.kruton.facts"})
@EnableWebMvc
@EnableTransactionManagement
@EnableNeo4jRepositories
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}
