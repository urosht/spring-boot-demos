FROM openjdk:11.0.2-jre-stretch

COPY target/probesdemo*.jar /opt/app.jar
EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -jar /opt/app.jar
