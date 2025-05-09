# Imagen base con Java 17 (ajuste según su versión)
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR a la imagen
COPY target/sgcm-0.0.1-SNAPSHOT.jar sgcm-0.0.1-SNAPSHOT.jar

# Puerto que expone la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "sgcm-0.0.1-SNAPSHOT.jar"]