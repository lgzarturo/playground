# Docker

## Comandos 

Generar la imagen a partir del Docker file.

```bash
$ docker build -t {app_name}:{version} .
```

Generar una red para los microservicios

```bash
$ docker network create {cloud_name}
```

Crear el contenedor

```bash
$ docker run -p 8888:8080 
--name {service_name} 
--network {cloud_name}
{app_name}:{version}
```

MySQL

```bash
$ docker pull mysql:8
$ docker run -p 3306:3306 --name mysql8-service 
--network {cloud_name}
-e MYSQL_ROOT_PASSWORD={pass} 
-e MYSQL_DATABASE={db_name}
-d mysql:8
$ docker logs -f mysql8-service
```

PostgreSQL

```bash
$ docker pull postgres:12-alpine
$ docker run -p 5432:5432 --name postgres12-service
--network {cloud_name}
-e POSTGRES_PASSWORD={pass}
-e POSTGRES_DB={db_bame}
-d postgres:12-alpine
```

## Básico para aplicaciones java

```docker
FROM openjdk:11-alpine
MAINTAINER <email>
VOLUME /tmp
EXPOSE 8080
ADD ./target/app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```

## Micro servicios con puerto aleatorio

```docker
FROM openjdk:11-alpine
MAINTAINER <email>
VOLUME /tmp
ADD ./target/app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```

```bash
$ docker run -P --network {cloud_name} {imagen_service}:{version}
```

Generar un jar con maven

```bash
./mvnw clean package -DskipTests
```

Instancia de rabbitmq

```bash
$ docker pull rabbitmq:3.8-management-alpine
$ docker run -p 15672:15672 -p 5672:5672 
--name rabbit38-service
--network {cloud_name} 
-d rabbitmq:3.8-management-alpine
```

## Instancia de zipkin

> primero es necesario crear la base de datos zipkin en mysql y crear el schema, crear el usuario zipkin con los privilegios DELETE, EXECUTE, INSERT, SELECT, SHOW, VIEW y UPDATE

```docker
FROM openjdk:11-alpine
MAINTAINER <email>
VOLUME /tmp
EXPOSE 9411
ADD ./zipkin.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"] 
```

```bash
$ docker build -t zipkin-service:1.0.0 .
$ docker run -p 9411:9411 --name zipkin-service 
--network {cloud_name}
-e RABBIT_ADDRESSES=rabbit38-service:5672
-e STORAGE_TYPE=mysql
-e MYSQL_USER=zipkin
-e MYSQL_PASS=zipkin 
-e MYSQL_HOST=mysql8-service 
-d zipkin-service:1.0.0
```

Detener todos los contenedores en ejecución 

```bash
$ docker stop $(docker ps -q)
```

Eliminar todos los contenedores

```bash
$ docker rm $(docker ps -aq)
```

Eliminar todas la imagenes

```bash
$ docker rmi $(docker images -aq)
```

## Docker Compose "docker-compose.yml" ≥ 18.6

```docker
version: '3.7'
services:
  config-server:
    image: config-server:v1
    ports:
      - "8888:8888"
    restart: always
    networks:
      - springcloud
  servicio-eureka-server:
    image: servicio-eureka-server:v1
    ports:
      - "8761:8761"
    restart: always
    networks:
      - springcloud
  microservicios-mysql8:
    image: mysql:8
    ports:
      - "3306:3306"
    restart: always
    networks:
      - springcloud
    environment: 
      MYSQL_DATABASE: db_springboot_cloud
      MYSQL_ROOT_PASSWORD: sasa
  microservicios-postgres12:
    image: postgres:12-alpine
    ports:
      - "5432:5432"
    restart: always
    networks:
      - springcloud
    environment: 
      POSTGRES_DB: db_springboot_cloud
      POSTGRES_PASSWORD: sasa
  servicio-productos:
    image: servicio-productos:v1
    restart: always
    networks:
      - springcloud
    depends_on: 
      - config-server
      - servicio-eureka-server
      - microservicios-mysql8
  servicio-items:
    image: servicio-items:v1
    ports:
      - "8002:8002"
      - "8005:8005"
      - "8007:8007"
    restart: always
    networks:
      - springcloud
    depends_on: 
      - config-server
      - servicio-eureka-server
      - servicio-productos
   servicio-usuarios:
    image: servicio-usuarios:v1
    restart: always
    networks:
      - springcloud
    depends_on: 
      - config-server
      - servicio-eureka-server
      - microservicios-postgres12
   servicio-oauth:
    image: servicio-oauth:v1
    ports:
      - "9100:9100"
    restart: always
    networks:
      - springcloud
    depends_on: 
      - config-server
      - servicio-eureka-server
      - servicio-usuarios
  servicio-zuul-server:
    image: servicio-zuul-server:v1
    ports:
      - "8090:8090"
    restart: always
    networks:
      - springcloud
    depends_on: 
      - config-server
      - servicio-eureka-server
      - servicio-productos
      - servicio-items
      - servicio-usuarios
      - servicio-oauth
  microservicios-rabbitmq38:
    image: rabbitmq:3.8-management-alpine
    ports:
      - "15672:15672"
      - "5672:5672"
    restart: always
    networks:
      - springcloud
  zipkin-server:
    image: zipkin-server:v1
    ports:
      - "9411:9411"
    restart: always
    networks:
      - springcloud
    depends_on: 
      - microservicios-rabbitmq38
      - microservicios-mysql8
    environment: 
      RABBIT_ADDRESSES: microservicios-rabbitmq38:5672
      STORAGE_TYPE: mysql
      MYSQL_USER: zipkin
      MYSQL_PASS: zipkin
      MYSQL_HOST: microservicios-mysql8
networks:
  springcloud:
```