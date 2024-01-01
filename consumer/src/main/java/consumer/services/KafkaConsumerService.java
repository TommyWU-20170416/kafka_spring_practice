package consumer.services;

import consumer.config.KafkaConfig;
import consumer.model.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

//    @KafkaListener(topics = KafkaConfig.TEST_TOPIC, groupId = KafkaConfig.GROUP_1)
//    public void consume(String message) {
//        LOGGER.info("Consumed message: {} ", message);
//    }

    /**
     * 抓 properties 的寫法
     * 同個 kafkaListener 同個 groupId 會出現無法接收的情況
     *
     * @param message
     */
    @KafkaListener(topics = "${kafka.topic.test}", groupId = "${kafka.group1.id}")
    public void consumeWithValue(String message) {
        LOGGER.info("Consumed message: {} ", message);
    }

    /**
     * 多設定 containerFactory 以及 UserVo
     *
     * @param user
     * @throws InterruptedException
     */
//    @KafkaListener(topics = KafkaConfig.JSON_TOPIC, groupId = KafkaConfig.GROUP_2, containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(UserVo user) throws InterruptedException {
//        LOGGER.info("Consumed JSON Message: {} ", user);
//    }

    @KafkaListener(topics = "${Kafka.topic.json}", groupId = "${kafka.group2.id}", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(UserVo user) throws InterruptedException {
        LOGGER.info("Consumed JSON Message: {} ", user);
    }
}
