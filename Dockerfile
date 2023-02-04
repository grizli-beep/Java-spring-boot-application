# Fetching latest version of Java
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/SpringTest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080