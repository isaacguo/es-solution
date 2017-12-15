FROM openjdk:8-jdk-alpine
MAINTAINER Isaac Guo <yue_guo@keysight.com>

USER root
ENV HOME /root
VOLUME /tmp
ARG JAR_FILE=./target/es-gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8080

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "--eureka.client.serviceUrl.defaultZone=http://es-eureka:8761/eureka"]
