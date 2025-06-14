# Partimos de una imagen de Java 17 con Alpine (más ligera)
FROM openjdk:17-jdk-alpine
# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app
# Copiamos el JAR generado en el contenedor
COPY target/EmployeeHP-0.0.1-SNAPSHOT.jar app.jar
# Exponemos el puerto 8080 (el que usa Spring Boot por defecto)
EXPOSE 8085
# Comando para ejecutar la aplicación cuando el contenedor arranque
ENTRYPOINT ["java", "-jar", "app.jar"]