# Prepare a Docker stack for Kafka & Zookeeper as per theories learnt on prior day.

### Overview :

=> This project contains snippets as docker-compose file and configurations to deploy kafka and zookeeper . 

=> Here images of confluentinc are used for zookeeper and kafka .

1. confluentinc/cp-kafka : latest
2. confluentinc/cp-zookeeper : latest

=> EXPOSED Ports are : 

1.  2181 ->  zookeeper listens on port 2181 .
2.  9092 ->  kafka listens on port 9092 .

=> Many environment variables are also declared corresponding to zookeeper and kafka image .


### Running : 

Below are the snippets for service definition of kafka and zookeeper in a docker-compose file . 


#### Zookeeper :

```
   zookeeper:
      image: 'confluentinc/cp-zookeeper:latest'
      hostname: 'zookeeper'
      ports:
         - < host port : container port > 
      environment:
         ZOOKEEPER_CLIENT_PORT : < Port where zookeeper listen for the connection >
         ZOOKEEPER_TICK_TIME : < minimum session timeout for zookeeper >
         
```

#### Kafka :

```

   kafka:
      image: 'confluentinc/cp-kafka:latest'
      hostname: < name of the host>
      ports:
        - < host port : container port >
      environment:
         KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:< zookeeper client port >'
         KAFKA_BROKER_ID : <broker id>
         KAFKA_ADVERTISED_LISTENERS : 'INSIDE://:9092 , OUTSIDE://<host IP address>'
      depends_on:
        - < zookeeper service name >
  

```


#### Commands to deploy the application using docker-compose file in docker swarm

```
1. Initialize the swarm :

docker swarm init


2. Deploy the docker stack : 

docker stack deploy --compose-file docker-compose.yml application

(here application is the name of deployed stack)

```
