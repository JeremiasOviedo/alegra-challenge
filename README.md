# Alegra Technical Challenge

Este es un challenge tecnico que hice como parte de mi proceso de seleccion en Alegra.

## Tech Stack

**Server:** Java, Spring, JPA, Docker, Linux.

**Cliente**: HTML, CSS, VueJS.

## Link al deploy

Aqui pueden encontrar la aplicacion deployada en un servidor Linux, usando el servicio de Droplets de DigitalOcean


[Link](http://164.90.185.14:8080/)


## Correrlo en local

Clona el proyecto
```bash
  git clone https://github.com/JeremiasOviedo/alegra-challenge.git
```
Dirigete al directorio del proyecto
```bash
  cd alegra-challenge
```
Configura la conexion a base de datos de los microservicios kitchen y warehouse en sus respectivos application.properties
 msvc-kitchen:
```bash
spring.datasource.url=jdbc:mysql://mysql8:3306/msvc_kitchen?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true
```
msvc-warehouse:
```bash
spring.datasource.url=jdbc:mysql://mysql8:3306/msvc_warehouse?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true
```
Ejecuta docker-compose
```bash
  docker-compose up
```
El servidor deberia iniciarse por defecto en la ip
```bash
  http://127.0.0.1:8080/
```


