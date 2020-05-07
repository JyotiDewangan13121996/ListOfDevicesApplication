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


### Docker stack for kafka , zookeeper and schema registry –(Confluent kafka images)


#### Overview :

=> This project contains snippets as docker-compose files and configurations to deploy kafka server and components.

=> Here images of confluentinc are used for zookeeper and kafka and schema registry .

1. confluentinc/cp-kafka : latest
2. confluentinc/cp-zookeeper : latest
3. confluentinc/cp-schema-registry : latest

=> EXPOSED Ports are : 

1.  2181 ->  zookeeper listens on port 2181 .
2.  9092 ->  kafka listens on port 9092 .
3.  8081 ->  schema registry listens on port 8081

=> Many environment variables are also declared corresponding to zookeeper and kafka image .



#### Running :

=> Below are the snippets for service definition of kafka,zookeeper and schema registry in a docker-compose file. I

#### Zokeeper :

```
  zookeeper:
    image:  confluentinc/cp-zookeeper:latest
    ports:
      - <host port:container port>
    environment:
      ZOOKEEPER_SERVER_ID: <Unique server ID for running in clustered mode>
      ZOOKEEPER_CLIENT_PORT: <Port where zooKeeper listen for connections by clients such as Kafka>
    volumes:
       - /var/run/docker.sock:/var/run/docker.sock
       - <path to data volumes for zookeeper>:/var/lib/zookeeper/data
       - <path to volumes for zookeeper logs>:/var/lib/zookeeper/log
    networks:
       - <Optional internal network to communicate with other services in the same stack
volumes:
  # create a persistent data volumes for zookeeper
 <data volume name for zookeeper>:
 <volume name for zookeeper logs>:
 ```
 
#### Kafka : 

```
  kafka:
    image: confluentinc/cp-kafka:latest
    ports:
      - target: <UDP port>
        published: <UDP port>
        protocol: udp
        mode: host
    environment:
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INSIDE:<name of kafka security protocol.Ex- SASL_PLAINTEXT>
      ,OUTSIDE:<name of kafka security protocol.Ex- SASL_PLAINTEXT>
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:<Zookeeper client port >
      KAFKA_ADVERTISED_LISTENERS: INSIDE://:9092,OUTSIDE://<host ip add>:9094
      KAFKA_LISTENERS: INSIDE://:9092,OUTSIDE://:9094
      KAFKA_INTER_BROKER_LISTENER_NAME: INSIDE
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: <replication factor for the __consumer_offsets internal topic it aligns with no of brokers>
    volumes:
       - /var/run/docker.sock:/var/run/docker.sock
       - <path to data volumes for kafka>:/var/lib/kafka/data
volumes:
  # create a persistent data volumes for kafka
 <data volume name for kafka>:
```       

 
#### Schema Registry :

```
  schemaregistry:
    image: confluentinc/cp-schema-registry:latest
    environment:
      SCHEMA_REGISTRY_HOST_NAME: <Name for schemaregistry>
      SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS: <kafka service name:port>
       # Kafka Security Config #
      SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS: <name of kafka security protocol. For Kafka security SASL_PLAINTEXT >://:9092,
      <name of kafka security protocol.Default is PLAINTEXT. For Kafka security SASL_PLAINTEXT >://<host ip add>:9094
    depends_on:
      - <zookeeper service name>
      - <kafka service name>
    ports:
      - <host port:container port>
    networks:
      - <Optional internal network to communicate with other services in the same stack>
 
    
```
