# Auth Service

Este proyecto es un servicio de autenticación que utiliza Spring Boot, H2 Database, Spring Security y la librería
`io.jsonwebtoken` para la generación de tokens JWT.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.5**
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **Spring Security**: Para la autenticación y autorización.
- **io.jsonwebtoken**: Para la generación y validación de tokens JWT.

## Endpoints

### Registro de Usuario

**Endpoint**: `/api/v1/user/register`

**Método**: `POST`

**Request Body**:

```json
{
  "name": "Xavier",
  "username": "xavy",
  "password": "password123",
  "repeatPassword": "password123"
}
```

**Response**:

```json
{
  "id": 4,
  "username": "xavy",
  "name": "Xavier",
  "role": null,
  "jwt": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiWGF2aWVyIiwiYXV0aG9yaXRpZXMiOltdLCJzdWIiOiJ4YXZ5IiwiaWF0IjoxNzMwNzc2MzQxLCJleHAiOjE3MzA3NzgxNDF9.1KE23eriqmC4hAQFh38jcj9_d1PnsVy_8dWIVuMDS_I"
}
```

### Inicio de Sesión

**Endpoint**: `/api/v1/auth/authenticate`

**Método**: `POST`

**Request Body**:

```json
{
  "username": "xavy",
  "password": "password123"
}
```

**Response**:

```json
{
  "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiWGF2aWVyIiwiYXV0aG9yaXRpZXMiOltdLCJzdWIiOiJ4YXZ5IiwiaWF0IjoxNzMwNzc1NjYzLCJleHAiOjE3MzA3Nzc0NjN9.KZssifsThRilfzXOTphnv0wriZ4sx1o10acmlevMNhw",
  "username": "xavy",
  "email": "",
  "role": ""
}
```

### Validación de Expressiones Regulares

Estos endpoints requieren un token JWT para su acceso.

**Endpoint**: `/api/v1/validate/numeric`

**Método**: `GET`

**Request Param**: `input`

**Response**:

```boolean
true | false
```

**Endpoint**: `/api/v1/validate/lowercase`

**Método**: `GET`

**Request Param**: `input`

**Response**:

```boolean
true | false
```

**Endpoint**: `/api/v1/validate/uppercase`

**Método**: `GET`

**Request Param**: `input`

**Response**:

```boolean
true | false
```

**Endpoint**: `/api/v1/validate/alphanumeric`

**Método**: `GET`

**Request Param**: `input`

**Response**:

```boolean
true | false
```

**Endpoint**: `/api/v1/validate/letter-and-number`

**Método**: `GET`

**Request Param**: `input`

**Response**:

```boolean
true | false
```

## Configuración

Asegúrate de tener configurado el archivo `application.properties` para utilizar la base de datos H2 y las configuraciones de seguridad necesarias.

## Ejecución

Para ejecutar el proyecto, utiliza el siguiente comando de Maven:

```bash
mvn spring-boot:run
```

Esto iniciará el servidor en el puerto configurado (por defecto, 8080).

## Notas

- La base de datos H2 se utiliza solo para desarrollo y pruebas.
- Los tokens JWT se generan y validan utilizando la librería `io.jsonwebtoken`.
- Asegúrate de proteger los endpoints sensibles utilizando Spring Security.
