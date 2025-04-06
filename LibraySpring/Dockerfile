# Etapa 1: Build com Gradle
FROM gradle:8.13-jdk21 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
RUN gradle build --no-daemon

# Etapa 2: Execução com JDK 
FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY --from=build /home/gradle/project/build/libs/app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]