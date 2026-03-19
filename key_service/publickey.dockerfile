# --- ETAPA 1: Compilación ---
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copiamos el pom.xml y descargamos dependencias (optimiza el cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# --- ETAPA 2: Imagen Final ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos solo el archivo JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto del microservicio
EXPOSE 8081

ENV REDIS_HOST=redis-cluster-keys
ENV REDIS_PORT=6379
ENV REDIS_PASSWORD=docker_rj_local_2026

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

