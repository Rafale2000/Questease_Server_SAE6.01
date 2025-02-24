package fr.uphf.questease.testintegration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = IntegrationTestRunner.class)
public class CucumberSpringConfiguration {
    // Additional configuration if needed
}