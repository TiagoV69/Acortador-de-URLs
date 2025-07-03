package com.portafolio.url_shortener.url_shortener_service.Repository;

import com.portafolio.url_shortener.url_shortener_service.Model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //  interfaz de repositorio
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> { 

    // spring Data JPA crea automaticamente la consulta para este metodo
    // busca un UrlMapping por su campo "shortCode"
    Optional<UrlMapping> findByShortCode(String shortCode);
}