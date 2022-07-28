FROM openjdk:11
RUN apt-get install curl -y
COPY ./target/medical-api-service-*.jar ./gateway.jar
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]