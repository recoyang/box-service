FROM openjdk:17-alpine
WORKDIR /home/app
COPY build/libs/box-service-0.1-all.jar /home/app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]
