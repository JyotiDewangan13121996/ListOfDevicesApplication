## Deploy that application using docker swarm using docker compose.That docker compose should be executable on any environment.

## Docker compose file for the application "ListOfDevices".

=> This project contains snippets as docker-compose file and configuration to deploy the application on Docker . 


###  Running :

=> Below is the docker-compose file to deploy the application "ListOfDevices" on docker swarm .


```
version: "3"
services:
  application:
    image: application
    ports:
      - "8080:8080

```

-> Here the service for the application is created using the Docker image "application" which will further execute the executable JAR of the application when the container nd services  of that will be up and running .

-> Here the port no 8080 is exposed to run the application.

#### Commands to deploy the application using docker-compose file in docker swarm

```
1. Initialize the swarm :

docker swarm init


2. Deploy the docker stack : 

docker stack deploy --compose-file docker-compose.yml application

(here application is the name of deployed stack)

```
