package tenders.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"tenders.server.repository"})
public class TendersServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(TendersServerApplication.class, args);
  }
}