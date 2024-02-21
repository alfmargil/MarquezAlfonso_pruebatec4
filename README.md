# Prueba Técnica 4: API Agencia de Viajes

Este proyecto consiste en el desarrollo de una API para gestionar una agencia de viajes

## Descripción del Proyecto

La API cuenta con los siguientes campos:

1. **Hoteles** Gestión de hoteles, se puede hacer CRUD completo y además cargar hoteles de forma individual, o una lista con varios hoteles y sus habitaciones.

2. **Vuelos** Gestión de vuelos, se puede hacer CRUD completo y también cargar aviones.

2. **Reservas** Gestión de reservas tanto de vuelos como de hoteles

3. **Habitaciones** Gestión personalizada de habitaciones

## Tecnologías Utilizadas

- **IDE:** IntelliJ IDEA Community Edition 2023.3
- **Java:** JDK 17
- **Spring Boot 3.2.2**
- **Hibernate JPA (Java Persistence API)** para el acceso a la base de datos
- **MySQL** para la base de datos

## Estructura del Proyecto

- **src/main/java/com/config/:** Configuración de Spring Security
- **src/main/java/com/controller/:** Controladores Rest de Spring
- **src/main/java/com/DTO/:** DTO del modelado
- **src/main/java/com/model/:** Modelado con todas las clases y sus relaciones
- **src/main/java/com/repository/:** Interfaces que mediante JPA conectan con la DB
- **src/main/java/com/service/:** Implementacion de la mayoría de la lógica de servicio
- **src/main/java/com/util/:** Hay dos clases con útiles que plantee al principio pero que finalmente no he usado, los he dejado por si en futuras actualziaciones se usan


## Configuración

1. **Requisitos previos:** Asegúrate de tener instalado Java 17.

2. **Configuración de la base de datos:** Importa el archivo SQL del repositorio con la base de datos inicial.

3. **Ejecución del proyecto:** Abre el proyecto en IntelliJ, importa la base de datos y ejecuta.

## Casos Supuestos

- **Id persona** Suponemos que el ID de las personas es su documento identificativo y que no va a coincidir.
- **Restricciones** Por motivos de seguridad e integridad a la hora de hacer ciertas operaciones, como editar, no he permitido que se puedan editar todos los campos.
  Del mismo modo cuando vas a insertar un nuevo hotel, no hace falta aportar el codigo de hotel, ya que el software genera uno propio usando el nombre del lugar donde está
  y el número de hoteles de en ese mismo sitio. Hay varias consideraciones como esta en los distintos métodos del proyecto con el objetivo de que sea lo más integro posible.

## Documentación

Apenas he comentado los métodos, ya que la mayoría se puede saber que hacen por su nombre. Algún método más complejo si ha sido comentado
