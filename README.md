# Microservicio Acortador de URLs

Un microservicio simple y eficiente desarrollado con Spring Boot para acortar URLs. Este proyecto sirve como demostración de los principios de diseño de API REST, arquitectura limpia y buenas prácticas de desarrollo de backend.

## Características Principales

- **API RESTful:** Endpoints claros para crear y redirigir enlaces.
- **Validación de Entrada:** Asegura que solo se procesen URLs validas, rechazando datos incorrectos.
- **Manejo de Errores Global:** Respuestas de error consistentes y en formato JSON gracias a un manejador de excepciones centralizado.
- **Persistencia de Datos:** Uso de Spring Data JPA con una base de datos en memoria (H2) para un desarrollo agil.
- **Documentacion Automatica:** la api esta completamente documentada y es interactiva a traves de Swagger UI (OpenAPI).

##  Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database** (en memoria)
- **Maven**
- **Lombok**
- **SpringDoc OpenAPI (Swagger)**

##  Cómo Empezar

Sigue estos pasos para ejecutar el proyecto

### Prerrequisitos

- JDK 17 o superior instalado.
- Maven instalado.
- Un IDE como IntelliJ IDEA, Eclipse o VSCode.

### Instalación y Ejecución

1.  **Clona el repositorio:**
    ```sh
    git clone https://URL-DE-TU-REPOSITORIO.git
    cd url-shortener
    ```

2.  **Compila el proyecto con Maven:**
    ```sh
    mvn clean install
    ```

3.  **Ejecuta la aplicación:**
    ```sh
    mvn spring-boot:run
    ```

La aplicación estará corriendo en 'http://localhost:8080'.

## Endpoints de la API

### 1. Acortar una URL

Crea un nuevo enlace corto a partir de una URL larga.

- **Método:** 'POST'
- **URL:** '/api/v1/shorten'
- **Body (JSON):**
  ```json
  {
    "url": "https://www.google.com/search?q=spring+boot"
  }

### Tipo de respuestas

Respuesta de Éxito (201 Created):   http://localhost:8080/unCodigoAleatorio

Respuesta de Error (400 Bad Request):

{
  "url": "Debe proporcionar una URL válida."
}

### 2. Redirigir a la URL Original

Accede a un enlace corto para ser redirigido a la URL original.
Método: GET
URL: /{shortCode}
Ejemplo: http://localhost:8080/unCodigoAleatorio
Respuesta de Éxito: Redirección HTTP 302 a la URL original.
Respuesta de Error (404 Not Found):

{
  "error": "No se encontró una URL para el código: unCodigoAleatorio"
}

### Documentación Interactiva (Swagger)
Corre la aplicacion y asi puedes acceder a la documentacion interactiva de la API creada por el sawgger 
http://localhost:8080/swagger-ui/index.html

desde esta interfaz podrias ver todos los detalles de los endpoints y probarlos directamente :D