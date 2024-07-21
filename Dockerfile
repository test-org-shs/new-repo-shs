FROM openjdk:23-slim-bullseye
LABEL authors="SHS"

COPY build/libs/shs-0.0.1-SNAPSHOT.jar /

RUN apt upgrade

ENTRYPOINT ["java", "-jar","shs-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080