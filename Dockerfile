FROM openjdk:8
MAINTAINER "Surendra"

COPY /target/classes/static/* /home/static/

ADD /target/ui-microservices.jar ui-microservices.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "ui-microservices.jar"]
