# Service Layer .

=> Consists of KafkaProducer and Consumer for :

1. publishing data to topics to a kafka server.
2. consuming data from topics from a kafka server.

=> As Avro don't provide serializer and deserializer implicitly ,so here I have defined Avro Serializer and Deserialzer .

1. AvroSerializer
2. AvroDeserializer
