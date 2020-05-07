FROM openjdk:12-alpine
COPY target/Calculator*.jar calculator.jar
RUN apk --update add openjdk8-jre
ENTRYPOINT ["java", "-cp", "calculator.jar", "-Djava.security.egd=file:/dev/./urandom", "com.calculator.App"]
