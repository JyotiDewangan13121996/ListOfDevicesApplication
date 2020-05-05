# Implement avro schema for producer and consumer - kafka client application created in previous week.


### Overview : 

=> Its an application prototype for kafka client :

1. Producer  --> sends the topics to the kafka server
2. Consumer  --> consumes the topics from the kafka server
3. Avro schema  --> defined an avro schema "user.avsc" file under 'src/main/resources' directory and after building the application ,it will automatically create the 'User.java' class under 'src/main/java/avro.com.example.avro' directorty .  



### Building : 

=>  This project uses gradle build tool to build the application . Build steps consist of  building an executable JAR and a Docker-compose file which will run the docker image containing the executable JAR.

```
To build JAR and test
./gradlew clean build 

```

### Running : 

=> This application can be run using any IDE by running it as spring boot application . And the JUnit test cases can be run by running the application using JUnit framework .


=> It can be verified by : 

1. Deploy the docker-compose file for kafka and zookeeper on docker swarm .

#### Commands to deploy the application using docker-compose file in docker swarm

```
1. Initialize the swarm :

docker swarm init


2. Deploy the docker stack : 

docker stack deploy --compose-file docker-compose.yml application

(here application is the name of deployed stack)

```

2. Running the application on the any IDE by running it as spring boot application.

3. Check where the topics are published or consumed on kafka server or not

#### To check whether topics are being published or consumed on kafka server or not using kafka server.

```
1. To execute the bash for kafka's container : 

docker exec -it <container_id> /bin/bash


2. To change the directory to access all the ".sh" files

cd /opt/confluentinc/kafka/bin

3. To start a consumer : 

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic KafkaProducer 
               --from-begining
      
                OR
                
 To start a producer : 
 
 kafka-console-producer.sh --broker-list localhost:9092  --topic KafkaProducer  

```


