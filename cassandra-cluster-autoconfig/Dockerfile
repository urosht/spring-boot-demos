FROM maven:3.5-jdk-8-onbuild AS builder-image

FROM anapsix/alpine-java:8u172b11_jdk
COPY --from=builder-image /usr/src/app/target/*.jar /opt/app.jar

ENV TZ=Europe/Madrid
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo "$TZ" > /etc/timezone

EXPOSE 8080
CMD java -jar $JAVA_OPTS /opt/app.jar
