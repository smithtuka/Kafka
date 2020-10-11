package com.galbern.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {
    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message)
    {
        this.producerService.sendMessage(message);
    }
}
