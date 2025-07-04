package com.portafolio.url_shortener.url_shortener_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition( // Anotacion que configura la info de OpenAPI
    info = @Info(
        title = "API Acortador de URLs", // Aqui dejamos el titulo de nuestra API
        version = "1.0.0", // Esta es la version de nuestra API :D
        description = "Un microservicio simple para acortar URLs. Este proyecto demuestra los fundamentos de Spring Boot, API REST, JPA y buenas practicas de desarrollo." 
    )
)
public class UrlShortenerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlShortenerServiceApplication.class, args);
    }

}