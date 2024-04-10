FROM openjdk:17-jdk-slim
VOLUME /tmp

COPY ./target/*.jar app.jar
COPY ./src/main/resources/application.properties application.properties
ENTRYPOINT ["java","-jar","/app.jar", "--Dspring.config.location","file:./application.properties"]