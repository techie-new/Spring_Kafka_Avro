package com.satya.controller;


import com.satya.dto.Employee;
import com.satya.producer.KafkaAvroProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaAvroProducer kafkaProducer;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody Employee message) {
        kafkaProducer.send(message);
        return "Message sent successfully";
    }
}
