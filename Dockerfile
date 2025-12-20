FROM eclipse-temurin:21-jdk

LABEL maintainer="Dosya"

COPY backend.jar my-backend-spring-project.jar

ENTRYPOINT ["java", "-jar", "my-backend-spring-project.jar"]