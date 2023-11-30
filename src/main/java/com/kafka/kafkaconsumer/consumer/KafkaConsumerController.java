package com.kafka.kafkaconsumer.consumer;

import com.google.gson.Gson;
import com.kafka.kafkaconsumer.dto.Employee;
import com.kafka.kafkaconsumer.util.KafkaLogger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class KafkaConsumerController {

    @KafkaListener(topics = "LogTopic",groupId = "group-id")
    public void listenMsg(String employeeJson) {
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJson , Employee.class);
        KafkaLogger.LOGGER().info("Received : "+employee);
    }
}
