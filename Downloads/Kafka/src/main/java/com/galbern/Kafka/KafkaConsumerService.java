package com.galbern.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
//    private final Logger logger =
//            LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = AppConstant.TOPIC_NAME,
            groupId = AppConstant.GROUP_ID)
    public void consume(String message)
    {
        System.out.println(message);
//        logger.info(String.format("Message recieved -> %s", message));
    }
}
