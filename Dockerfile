FROM openjdk:17-alpine

WORKDIR /usr/src/app

EXPOSE 9096

ENTRYPOINT ["java", "-jar", "recipes-0.0.1-SNAPSHOT.jar"]

