package com.portafolio.url_shortener.url_shortener_service.Service;

import com.portafolio.url_shortener.url_shortener_service.Model.UrlMapping;
import com.portafolio.url_shortener.url_shortener_service.Repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Random;

@Service // componente de servicio gestionado por Spring
public class UrlShorteningService {

    private final UrlMappingRepository urlMappingRepository;

    // Inyeccion de dependencias por constructor 
    public UrlShorteningService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String shortenUrl(String originalUrl) {
        // logica para generar un codigo corto
        // generamos un hash simple y lo codificamos en Base64 para hacerlo URL-safe
        Random random = new Random();
        byte[] randomBytes = new byte[6];
        random.nextBytes(randomBytes);
        String shortCode = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        
        // creamos nuestro objeto de entidad para guardarlo
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortCode(shortCode);
        urlMapping.setCreationDate(LocalDateTime.now());
        
        // usamos el repositorio para guardar el objeto en la base de datos
        urlMappingRepository.save(urlMapping);
        
        return shortCode;
    }
}