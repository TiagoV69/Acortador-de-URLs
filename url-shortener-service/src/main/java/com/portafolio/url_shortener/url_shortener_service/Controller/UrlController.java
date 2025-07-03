package com.portafolio.url_shortener.url_shortener_service.Controller;

import com.portafolio.url_shortener.url_shortener_service.Dto.ShortenRequest;
import com.portafolio.url_shortener.url_shortener_service.Model.UrlMapping;
import com.portafolio.url_shortener.url_shortener_service.Repository.UrlMappingRepository;
import com.portafolio.url_shortener.url_shortener_service.Service.UrlShorteningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;


@RestController // cmbina @Controller y @ResponseBody. Indica que las respuestas serán JSON o XML, no vistas HTML.
@RequestMapping("/") // Todas las rutas en este controlador empezarán con "/".
public class UrlController {

    private final UrlShorteningService urlShorteningService;
    private final UrlMappingRepository urlMappingRepository; // necesitamos el repo para buscar


    public UrlController(UrlShorteningService urlShorteningService, UrlMappingRepository urlMappingRepository) {
        this.urlShorteningService = urlShorteningService;
        this.urlMappingRepository = urlMappingRepository;
    }

    // este endpoint para crear un enlace corto
    @PostMapping("/api/v1/shorten") // mapea peticiones POST a esta ruta.
    public ResponseEntity<String> shortenUrl(@RequestBody ShortenRequest request) { // @RequestBody convierte el JSON de la petición a nuestro objeto DTO.
        String shortCode = urlShorteningService.shortenUrl(request.getUrl());

        // Devolvemos el código corto en el cuerpo de la respuesta con un estado 201(CREATED).
        String fullShortUrl = "http://localhost:8080/" + shortCode;
        return ResponseEntity.status(HttpStatus.CREATED).body(fullShortUrl);
    }

    // este endpoint redirige a la URL original
    @GetMapping("/{shortCode}") // mapea peticiones GET. {shortCode} es una variable en la ruta.
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode) { // 8. @PathVariable extrae el valor de la variable de la ruta.
        Optional<UrlMapping> urlMappingOptional = urlMappingRepository.findByShortCode(shortCode);

        if (urlMappingOptional.isPresent()) {
            String originalUrl = urlMappingOptional.get().getOriginalUrl();
            // si encontramos la URL, creamos una respuesta de redirección (HTTP 302 Found).
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(originalUrl)) // se añade la cabecera "Location" con la URL original.
                    .build();
        } else {
            // si no lo encuentra devolvemos un 404(Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}