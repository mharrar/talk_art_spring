package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootTest
class TalkartApplicationTests {
    @BeforeAll
    public static void setupEnvironment() {
        // Charger les variables d'environnement depuis le fichier .env
        Dotenv dotenv = Dotenv.configure()
                .filename("var.env")
                .directory("C:\\Users\\Ce pc\\Documents\\workspace-spring-tool-suite-4-4.22.0.RELEASE\\talkart")
                .load();
        System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
        System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));
    }


	@Test
	void contextLoads() {
	}

}
