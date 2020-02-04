FROM openjdk:11.0.2-jre-stretch

COPY target/demo*.jar /opt/app.jar
EXPOSE 8080 5005

RUN chown -R nobody /opt/app.jar
USER nobody

ENTRYPOINT exec java $JAVA_OPTS -jar /opt/app.jar
