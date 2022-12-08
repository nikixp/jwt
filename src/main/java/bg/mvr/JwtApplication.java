package bg.mvr;

import bg.mvr.controller.AuthController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(new ObjectMapper().writeValueAsString(new AuthController.LoginRequest("user", "password")));
    }
}
