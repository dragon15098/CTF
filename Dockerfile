FROM openjdk:8-jdk-alpine
RUN apk add --no-cache curl
ARG JAR_FILE=target/*.jar
ARG FLAG_FILE=flag.txt
ARG PROPERTIES_FILE=./src/main/resources/application.properties
COPY ${JAR_FILE} app.jar
COPY ${FLAG_FILE} flag.txt
COPY ${PROPERTIES_FILE} ./src/main/resources/application.properties
ENTRYPOINT ["java","-jar","/app.jar"]
