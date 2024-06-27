FROM openjdk:17-jdk-slim

WORKDIR /app

ADD target/rest-api-docker.jar rest-api-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/rest-api-docker.jar"]