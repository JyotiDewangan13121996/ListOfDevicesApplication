#  Dockerize that application using docker with usage of dockerfile and create docker image of that application.


FROM openjdk:latest

WORKDIR /app

COPY ./build/libs/*.jar  ./app/spring-boot-application.jar

EXPOSE 8080

CMD ["java" , "-jar" ,"./app/spring-boot-application.jar"]

=> Here docker image "openjdk:latest" is used to dockerize the application.

=> Here WORKDIR for the application is "/app" .

=> The jar file generated for the application which is present in the directory "./build/libs/" is copied to working directory
  "./app/spring-boot-application.jar".
  
=> After that the port no. 8080 is exposed .

=> After that command " CMD ["java" , "-jar" ,"./app/spring-boot-application.jar"]  " is provided to run the application whenever the docker image will be up and running .
