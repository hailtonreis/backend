# Etapa de build (opcional, se você quiser buildar dentro do Docker)
# FROM maven:3.9.4-eclipse-temurin-21 AS build
# COPY . /app
# WORKDIR /app
# RUN mvn clean package -DskipTests

# Etapa de execução (utilize isso se já tem o JAR gerado)
FROM eclipse-temurin:21-jdk

# Cria o diretório da aplicação
WORKDIR /app

# Copia o JAR gerado (certifique-se que o .jar existe na pasta target)
COPY target/*.jar app.jar

# Exponha a porta do seu app (ex: Spring Boot usa por padrão a 8080)
EXPOSE 8080

# Comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
