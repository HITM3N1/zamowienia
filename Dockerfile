FROM maven:3.9.12-eclipse-temurin-25

WORKDIR /app

COPY pom.xml .
COPY src ./src

COPY src/main/resources/appsettings.docker.properties ./src/main/resources/appsettings.properties
COPY src/main/resources/.env.docker ./src/main/resources/.env

RUN mvn clean package

CMD ["java", "-jar", "target/zamowienia.jar"]