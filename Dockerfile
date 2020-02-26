# latest oracle openjdk is the basis
FROM openjdk:oracle
# copy jar file into container image under app directory
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} diff-number-service.jar
# expose server port accept connections
EXPOSE 8080
# start application
CMD ["java", "-jar", "diff-number-service.jar"]