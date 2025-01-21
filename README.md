<h1>Foro Hub 💻🖱️📰</h1>

![Static Badge](https://img.shields.io/badge/ESTADO%20-EN%20DESARROLLO%20-%20GREEN)
![Static Badge](https://img.shields.io/badge/JAVA%20-%20JDK%2017-%20blue)
![Static Badge](https://img.shields.io/badge/Maven%20-%204.0.0%20-%20purple)
![Static Badge](https://img.shields.io/badge/Spring%20Boot%20-%203.4.1%20-%20red)
![MySQL 8.0](https://img.shields.io/badge/MySQL-8.0-orange)




### Descripción 📝
<h3>Challenge de Foro Hub - ONE </h3>
<p>EEste proyecto consiste en el desarrollo de una API REST en Spring Boot para un foro en línea diseñado para estudiantes. La aplicación permite a los usuarios plantear dudas y compartir respuestas en torno a diferentes temas o tópicos específicos. Entre las funcionalidades principales se incluyen:

- **`Gestión de usuarios:`**  Registro, autenticación y autorización utilizando JWT para seguridad stateless.
- **`Gestión de tópicos`** : Creación, actualización y eliminación de temas para organizar las discusiones.
- **`Publicación de preguntas y respuestas:`** Los usuarios pueden plantear dudas y responder a otros dentro de cada tópico.
- **`Estructura escalable:`** Diseño basado en buenas prácticas REST para garantizar la extensibilidad y el mantenimiento del sistema.
- **`Seguridad:`** Implementación de medidas de protección para garantizar el acceso controlado y evitar acciones no autorizadas.

Esta API promueve desarrollar una solución robusta para fomentar la colaboración y el intercambio de conocimientos en un entorno académico.
 
  </p>

## Tecnologías Utilizadas🖥️
- **`Lenguaje de Programación:`** Java - JDK 17
- **`Entorno de Desarrollo Integrado (IDE)`**: IntelliJ IDEA 
- **`Proyecto Maven`**: Maven 4.0.0, Estructura de librerias del proyecto.
- **`Spring Framework`**: Spring Boot 3.4.1. Estructura del proyecto
- **`MySQL`**: MySQL Workbench 8.0. Gestor local de base de datos
-  **`Control de Versiones`**: Git / GitHub

## Funcionalidad del Proyecto 🛠️
La aplicación estará disponible en `http://localhost:8080`

**`Endpoints principales:`**

**`/login:`** Endpoint para autenticación de usuarios. Envía una solicitud POST con un JSON que contiene username y password.
**`/usuarios:`** Endpoint para listar usuarios. Requiere autenticación mediante un token JWT.

**`/topicos:`** Endpoint para manejar la creación, actualización y eliminación de tópicos.

**Ejemplos de Solicitudes:**
**`Autenticación`**
  
  ```POST http://localhost:8080/login```

- Body

  ```
  {
  "email": "string",
  "password": "string"
  }
  ```

- Respuesta
 ```
 {
    "token": "jwt_token_generado"
}
```

**`Topico`**

-Solicitud 
```GET http://localhost:8080/topico/topicos```
- Header
```
   Authorization: Bearer jwt_token_generado
Content-Type: application/json
  ```
- Respuesta
```
  {
  "totalPages": 1073741824,
  "totalElements": 9007199254740991,
  "size": 1073741824,
  "content": [
    {
      "id": 9007199254740991,
      "titulo": "string",
      "mensaje": "string",
      "status": "ACTIVO",
      "idUsuario": 9007199254740991,
      "curso": "string",
      "fecha": "2025-01-21T19:26:44.762Z"
    }
  ],
  "number": 1073741824,
  "sort": {
    "empty": true,
    "sorted": true,
    "unsorted": true
  },
  "first": true,
  "last": true,
  "numberOfElements": 1073741824,
  "pageable": {
    "offset": 9007199254740991,
    "sort": {
      "empty": true,
      "sorted": true,
      "unsorted": true
    },
    "paged": true,
    "pageNumber": 1073741824,
    "pageSize": 1073741824,
    "unpaged": true
  },
  "empty": true
}
```

## Alcances Futuros ⏱️
- **`Desarrollo de interfaz`**: generar una interfaz gráfica ejecutable en el navegador, que permita la interacción del usuario con el programa y haga más dinamica la experiencia con él y que permitan la gestión de las sesiones, sus respuestas y demás interacciones.
- **`Cuentas de Usuario`**: permitir que los usuarios puedan crear su perfil en el que puedan guardar la información de las interacciones en Foro Hub
- **`Integración de metodos de seguridad`**: aumentar y mejorar los controles de seguridad de la información de la aplicación que impida la vulnerabilidad por parte de terceros.
- - **`Metodos de autenticación`**: Implementar otros métodos de autenticación en el API, por ejemplo con el correo, numero de telefono, repositorio u otros.
