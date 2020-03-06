package co.simplon.upskilling.filrougemusique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FilRougeMusiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilRougeMusiqueApplication.class, args);
    }

}
