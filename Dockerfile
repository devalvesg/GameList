# FROM maven:3.9.3-amazoncorretto-8-debian as build
# COPY /src /app/src
# COPY /pom.xml / app
# RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:17-oracle
COPY src/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

