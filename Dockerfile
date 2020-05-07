FROM openjdk:12-alpine
COPY hello.java Hello.java
RUN apk --update add openjdk8-jre
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "Hello.java"]