FROM openjdk:11.0.7-jre-slim
WORKDIR /app
COPY ./target/medical-discovery-server-*.jar ./service-discovery.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "service-discovery.jar"]