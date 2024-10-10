package prime_numbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class PrimesApp {
    public static void main(String[] args) {
        SpringApplication.run(PrimesApp.class, args);
    }
}
