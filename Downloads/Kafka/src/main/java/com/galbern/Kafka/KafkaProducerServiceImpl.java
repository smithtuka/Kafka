package com.galbern.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl  implements KafkaProducerService{

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message) {
        kafkaTemplate.send(AppConstant.TOPIC_NAME, message);
    }
}
