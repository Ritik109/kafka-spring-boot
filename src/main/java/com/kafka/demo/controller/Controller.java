package com.kafka.demo.controller;

import com.kafka.demo.dto.UserKafkaDTO;
import com.kafka.demo.entity.User;
import com.kafka.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/kafka-sample")
public class Controller {

    @Autowired
    private KafkaTemplate<String, UserKafkaDTO> kafkaTemplate;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @PostMapping("/produce")
    public void produceMessage(@RequestParam String topicName, @RequestBody User user) {
        UserKafkaDTO kafkaMessage = UserMapper.toUserKafkaDTO(user);
        kafkaTemplate.send(topicName, kafkaMessage);
    }

    @KafkaListener(topics = "Test", groupId = "myGroup")
    public void listen(UserKafkaDTO message) {
        System.out.println("Received Message (Test Topic) in group - group-id: " + message.toString());
    }

    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void listenAnotherTopic(UserKafkaDTO message) {
        System.out.println("Received Message (myTopic) in group - group-id: " + message.toString());
    }
}
