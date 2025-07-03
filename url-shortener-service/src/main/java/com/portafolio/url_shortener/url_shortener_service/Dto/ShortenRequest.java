package com.portafolio.url_shortener.url_shortener_service.Dto;

import lombok.Data;

@Data // Lombok para getters y setters
public class ShortenRequest {
    private String url;
}