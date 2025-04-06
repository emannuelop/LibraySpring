# Etapa 1: Build com Gradle
FROM gradle:8.13-jdk21 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN gradle build --no-daemon

# Etapa 2: Execução com JDK 
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]