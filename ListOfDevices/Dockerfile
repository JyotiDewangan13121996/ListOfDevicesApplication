FROM openjdk:latest

WORKDIR /app

COPY ./build/libs/*.jar  ./app/spring-boot-application.jar

EXPOSE 8080

CMD ["java" , "-jar" ,"./app/spring-boot-application.jar"]