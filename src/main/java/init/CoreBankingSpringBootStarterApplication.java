package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"controller", "security", "dao", "model", "service"})
@SpringBootApplication
@EnableJpaRepositories("dao")
@EntityScan("model")
public class CoreBankingSpringBootStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreBankingSpringBootStarterApplication.class, args);
    }

}
