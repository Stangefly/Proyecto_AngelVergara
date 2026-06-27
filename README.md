# Sistema de Aduanas - Paso Fronterizo Los Libertadores

## Contexto del Proyecto
Este proyecto consiste en una arquitectura orientada a microservicios diseñada para digitalizar, controlar y optimizar el registro de vehículos en el paso fronterizo Los Libertadores. Está construido bajo el patrón CSR (Controller-Service-Repository) asegurando una separación clara de responsabilidades y preparándose para escalar en un ecosistema distribuido.

## Integrantes del Equipo
* [Angel Vergara]

## Stack Tecnológico
* **Core:** Java 25, Spring Boot 3
* **Base de Datos:** MySQL 
* **Documentación de API:** Swagger / OpenAPI
* **Testing:** JUnit 5, Mockito
* **Herramientas de Desarrollo:** Lombok, Maven, Git

## Microservicios Implementados (Fase 1)
Para esta entrega, se ha consolidado el "molde base" de la arquitectura para garantizar calidad antes de la expansión a los 10 servicios requeridos.

* ✅ **ms_auto (Activo):** Servicio core que gestiona el ingreso, modificación, listado y eliminación de vehículos. Implementa validaciones de DTOs, manejo de entidades y pruebas unitarias con simulación de repositorios (Mockito), superando el 80% de cobertura en la capa de negocio.

## Instrucciones de Ejecución Local (Desarrollo)
Para levantar el ecosistema en un entorno local, sigue estos pasos:

1. Clonar el repositorio en tu máquina.
2. Iniciar el servidor local de base de datos MySQL (por ejemplo, mediante Laragon o XAMPP) asegurando que esté operando en el puerto `3306`.
3. Crear la base de datos correspondiente (ej. `db_auto`).
4. Importar el proyecto como un proyecto Maven en tu IDE (IntelliJ IDEA / VS Code) y descargar las dependencias.
5. Ejecutar la clase principal `MsAutoApplication`. El microservicio arrancará en el puerto `8081`.

## Documentación API (Swagger)
El proyecto incluye documentación técnica autogenerada e interactiva. Una vez que el microservicio esté en ejecución, puedes explorar y probar los endpoints directamente desde el navegador en la siguiente ruta:

👉 `http://localhost:8081/swagger-ui/index.html`
