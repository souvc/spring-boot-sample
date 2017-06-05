package sample.jpa.custom.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix="Impl")
public class App {

    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }
}
