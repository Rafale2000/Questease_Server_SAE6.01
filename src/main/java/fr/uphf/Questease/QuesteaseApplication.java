package fr.uphf.Questease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "fr.uphf.Questease")
public class QuesteaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuesteaseApplication.class, args);
	}
}

