FROM openjdk:11.0.7-jre-slim
WORKDIR /app
COPY ./target/*.jar ./app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]