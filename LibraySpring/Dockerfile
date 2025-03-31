FROM openjdk:21

COPY build/libs/LibraySpring-0.0.1-SNAPSHOT.jar /app/libray.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "libray.jar"]