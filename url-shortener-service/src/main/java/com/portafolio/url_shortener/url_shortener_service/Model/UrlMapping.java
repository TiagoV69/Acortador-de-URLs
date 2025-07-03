package com.portafolio.url_shortener.url_shortener_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity // Le dice a JPA que esta clase es una tabla en la BD
@Data   // Lombok que genera getters, setters y etc que genera automaticamente
@NoArgsConstructor // Lombok que genera un constructor sin argumentos, requerido por JPA
public class UrlMapping {

    @Id // (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Le dice a la BD que genere este valor automáticamenta autoincrementandose
    private Long id;

    @Column(nullable = false, unique = true) // Campo para el codigo corto. No puede ser nulo y debe ser unico
    private String shortCode;

    @Column(nullable = false, length = 2048) // Campo para la URL original. No puede ser nulo y le damos un tamaño grande
    private String originalUrl;

    @Column(nullable = false) // Campo para la fecha de creacion
        private LocalDateTime creationDate;
}