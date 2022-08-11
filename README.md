# KafkaExercise
Simple chat application using Java Spring Boot, REST API and Apache Kafka.
# Before Getting Started
Activate Apache Kafka using "docker-compose up -d" command with "docker-compose.yml" file containing the following configurations:

version: '2'

services:

  zookeeper:
  
    image: bitnami/zookeeper:latest
    
    environment:
    
      ZOOKEEPER_CLIENT_PORT: 2181
      
      ZOOKEEPER_TICK_TIME: 2000
      
      ALLOW_ANONYMOUS_LOGIN: "yes"
      
    ports:
    
      - 22181:2181
      
  kafka:
  
    image: bitnami/kafka:latest
    
    depends_on:
    
      - zookeeper 
      
    ports:
    
      - "9092:9092"
      
      - "29092:29092"
      
    environment:
    
      KAFKA_BROKER_ID: 1
      
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      
      ALLOW_PLAINTEXT_LISTENER: "yes"
      
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      
      KAFKA_LISTENERS: PLAINTEXT://:9092,PLAINTEXT_HOST://0.0.0.0:29092
      
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_HOST://localhost:29092
      
# Getting Started
1) Open Kafka console and inside "bin" directory use the command:
   "kafka-console-consumer.sh --topic KafkaExTopic --from-beginning --bootstrap-server localhost:9092"
   to point Kafka to the application's topic.
2) Run Java project
3) Use swagger2 at "http://localhost:8080/swagger-ui.html" (or local IP path) to add messages to the chat
