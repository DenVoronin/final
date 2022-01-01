package hhr;

import hhr.entity.User;
import io.swagger.annotations.Api;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;


@SpringBootApplication
@ComponentScan("hhr")
@EnableJpaRepositories("hhr.repository")
@EntityScan("hhr.entity")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Main {

    public static void main(String[]args) {

        SpringApplication.run(Main.class, args);




    }
}
