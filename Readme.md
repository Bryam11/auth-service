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


## Uso de Expresiones Regulares (Regex)

En este proyecto, se utilizan expresiones regulares (regex) para validar diferentes tipos de entradas de usuario. Las expresiones regulares son patrones utilizados para buscar y manipular texto basado en reglas específicas. Son una herramienta poderosa para la validación de datos, ya que permiten definir criterios precisos y complejos de manera concisa.

### Importancia de las Expresiones Regulares

- **Validación de Datos**: Las regex permiten validar entradas de usuario de manera eficiente, asegurando que los datos cumplan con un formato específico antes de ser procesados.
- **Seguridad**: Ayudan a prevenir la inyección de datos maliciosos al validar y filtrar entradas.
- **Flexibilidad**: Pueden ser utilizadas para una amplia variedad de validaciones, desde simples verificaciones de formato hasta complejas reglas de negocio.


## Notas

- La base de datos H2 se utiliza solo para desarrollo y pruebas.
- Los tokens JWT se generan y validan utilizando la librería `io.jsonwebtoken`.
- Asegúrate de proteger los endpoints sensibles utilizando Spring Security.


## Presentación Personal
Mi nombre es [Bryam Xavier Chuchuca Guzman], y estoy en la materia de Aplicaciones Seguras. En este proyecto, desarrollé un servicio de autenticación utilizando Spring Boot y Spring Security. Implementé la generación de tokens JWT para la autenticación de usuarios y validación de expresiones regulares para la verificación de datos de entrada. Este proyecto me permitió explorar el uso de Spring Security y JWT para la protección de servicios web y la implementación de mecanismos de autenticación seguros.