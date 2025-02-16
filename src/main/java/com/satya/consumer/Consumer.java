package com.satya.consumer;


import com.satya.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {


    @KafkaListener(topics = "${topic.name}")
    public void consume(ConsumerRecord<String, Employee> record) {
        //log.info("KafkaConsumer Record: {}", record);
        //log.info("KafkaConsumer avro received message : {} with a key {}", record.value(), record.key());
        System.out.println("KafkaConsumer Record: "+record.value());

    }
}
