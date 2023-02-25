FROM eclipse-temurin:17-centos7

COPY target/tamrin-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT java -jar app.jar