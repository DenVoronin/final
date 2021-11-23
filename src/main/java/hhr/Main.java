package hhr;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("hhr")
@EnableJpaRepositories("hhr.repository")
@EntityScan("hhr.entity")
public class Main {

    public static void main(String[]args){
        SpringApplication.run(Main.class,args);
    }
}
