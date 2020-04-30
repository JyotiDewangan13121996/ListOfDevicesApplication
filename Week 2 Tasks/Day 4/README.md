# Prepare a Docker stack for Kafka & Zookeeper as per theories learnt on prior day.

=> Here images of confluentinc are used for zookeeper and kafka .

1. confluentinc/cp-kafka : latest
2. confluentinc/cp-zookeeper : latest

=> EXPOSED Ports are : 

1.  2181 ->  zookeeper listens on port 2181 .
2.  9092 ->  kafka listens on port 9092 .

=> Many environment variables are also declared corresponding to zookeeper and kafka image .
