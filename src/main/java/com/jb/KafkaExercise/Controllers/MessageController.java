package com.jb.KafkaExercise.Controllers;

import com.jb.KafkaExercise.Beans.RestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MessageController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("msg")
    @ResponseStatus(HttpStatus.OK)
    public void publish(@RequestBody RestMessage request) {
        kafkaTemplate.send("KafkaExTopic", request.getMessage());
    }
}
