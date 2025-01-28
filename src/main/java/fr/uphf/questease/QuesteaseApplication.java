package fr.uphf.questease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "fr.uphf.questease")
public class QuesteaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuesteaseApplication.class, args);
	}
}

