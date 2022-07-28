FROM openjdk:11.0.7-jre-slim
COPY ./target/medical-patients-service-*.jar ./patients-service.jar
RUN apt-get update
RUN apt-get install -y netcat
RUN apt-get install -y curl
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]