FROM maven:3.9.2-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=build /app/target/banco-0.0.1-SNAPSHOT.jar banco-0.0.1-SNAPSHOT.jar

ENV SPRING_PROFILES_ACTIVE=dev

EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=dev", "banco-0.0.1-SNAPSHOT.jar"]