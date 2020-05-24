FROM openjdk:8
ADD /target/ui-microservices.jar ui-microservices.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "ui-microservices.jar"]
