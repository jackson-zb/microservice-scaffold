FROM java:8-jdk-alpine

COPY ./target/user-svc-1.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch user-svc-1.0-SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "mail-svc-1.0.0.jar"]