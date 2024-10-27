package org.sylph.blinddate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SylphBlindDateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SylphBlindDateApplication.class, args);
    }

}
