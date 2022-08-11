package com.jb.KafkaExercise.Beans;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaExListener {
    @KafkaListener(topics = {"KafkaExTopic"}, groupId = "#1")
    public void listener(String data) {
        System.out.println("Message received: " + data);
        if (data.contains("t")) {
            System.out.println("Data contains letter 't'");
        }
    }
}
