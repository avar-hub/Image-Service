FROM openjdk:17
EXPOSE 8085
ADD /build/libs/Image-Service-0.0.1-SNAPSHOT.jar Image-Service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/Image-Service-0.0.1-SNAPSHOT.jar"]