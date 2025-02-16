package com.satya.producer;

import com.satya.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class KafkaAvroProducer {

    @Value("${topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void send(Employee employee) {
        CompletableFuture<SendResult<String, Employee>> future = kafkaTemplate.send(topic, UUID.randomUUID().toString(), employee);
        future.whenComplete((r, e) -> {
            if (e != null) {
                //log.error("Error while sending message", e);
            } else {
                //log.info("Message sent successfully with message {} with topic {} and in partition = {}", employee, r.getRecordMetadata().topic(), r.getRecordMetadata().partition());
            }
        });
    }


}
