FROM openjdk:11.0.7-jre-slim
RUN apt-get update
RUN apt-get install -y netcat
RUN apt-get install -y curl
COPY ./target/medical-api-service-*.jar ./gateway.jar
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]
