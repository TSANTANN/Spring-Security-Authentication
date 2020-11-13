package br.com.nalli;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Startup {
    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
         BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
         String result = bcryptPasswordEncoder.encode("admin123");
         System.out.println("Hash" + result);
    }
}
