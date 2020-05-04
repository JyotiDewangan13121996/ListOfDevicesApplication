#  Dockerize that application using docker with usage of dockerfile and create docker image of that application.

```
FROM openjdk:latest

WORKDIR /app

COPY ./build/libs/*.jar  ./app/spring-boot-application.jar

EXPOSE 8080

CMD ["java" , "-jar" ,"./app/spring-boot-application.jar"]

```


*****************************************************************************************************************

=> Here docker image "openjdk:latest" is used to dockerize the application.

=> Here WORKDIR for the application is "/app" .

=> The jar file generated for the application which is present in the directory "./build/libs/" is copied to working directory
  "./app/spring-boot-application.jar".
  
=> After that the port no. 8080 is exposed .

=> After that command " CMD ["java" , "-jar" ,"./app/spring-boot-application.jar"]  " is provided to run the application whenever the docker image will be up and running 




### Building : 

=>  This project uses gradle build tool to build the application . Build steps consist of  building an executable JAR and a Docker image containing the executable JAR .

```
To build JAR and test
./gradlew clean build 

To build the Docker image 
docker image build  -t application .

(Here application is the Docker image name )

```

### Running : 

=> The application can be run using Docker file . The "application" Docker image should start a container to run the application .

```
To start the container of the Docker image "application" 
docker container run -itd --name application_container -p 8080:8080 application

```

=> Here the container with the name "application_container" will start thereby starting the application (as it will run the executable JAR ) on port no. 9090 as we have published it on port no 8080.
