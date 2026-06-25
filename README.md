# SD Final — Backend

## Integrantes
- Emiliano Las Heras

## Tecnologías utilizadas
- Java 17
- Spring Boot 3.2.5
- Spring Security 6.x + OAuth2 Resource Server (JWT)
- Spring Data JPA + Hibernate
- H2 (base de datos embebida en memoria)
- Lombok
- Maven
- Auth0

## Requisitos de ejecución
- Java 17 o superior
- Maven 3.8+
- Variables de entorno configuradas

## Instrucciones paso a paso

### 1. Clonar el repositorio

```bash
git clone https://github.com/emilasheras/sd-final-backend.git
cd sd-final-backend
```

### 2. Configurar variables de entorno

**(check obsidian note "Sistemas Distribuidos Examen Final - Secrets")**

### 3. Compilar y ejecutar
```bash
mvn spring-boot:run
```

### 4. Verificar
- Público: `GET http://localhost:8080/api/public/ping` -> 200
- Privado sin token: `GET http://localhost:8080/api/private/hello` -> 401
- H2 Console: `http://localhost:8080/h2-console`

## Endpoints

| Método | Ruta | Acceso |
|--------|------|--------|
| GET | /api/public/ping | Sin autenticación |
| GET | /api/private/hello | JWT requerido |
| GET | /api/private/items | JWT requerido |
| POST | /api/private/items | JWT requerido |
