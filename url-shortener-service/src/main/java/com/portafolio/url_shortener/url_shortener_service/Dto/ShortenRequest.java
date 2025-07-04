package com.portafolio.url_shortener.url_shortener_service.Dto;

import org.hibernate.validator.constraints.URL;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL; // Importante hibernate-validator

@Data // Lombok para getters y setters
public class ShortenRequest {
    @NotBlank(message = "Error la URL no puede estar vacia.") // Nos asegura que el string no sea nulo ni esté en blanco.
    @URL(message = "Debe proporcionar una URL valida.") // Asegura que el string tenga formato de URL.
    private String url;
}