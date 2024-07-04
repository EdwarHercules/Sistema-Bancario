# Usa una imagen base de Java
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación en el directorio de trabajo
COPY target/Prueba-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el que tu aplicación está escuchando
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
