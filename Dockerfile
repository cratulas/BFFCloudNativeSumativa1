# Usar una imagen base de Java
FROM eclipse-temurin:21-jdk

# Crear un directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el JAR compilado
COPY target/backendCloud-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre tu app (por defecto Spring Boot usa 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación usando el perfil 'docker'
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
