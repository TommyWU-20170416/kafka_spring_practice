package consumer.config;

import consumer.model.UserVo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

//@EnableKafka
//@Configuration
public class KafkaConfig {

//    public static final String TEST_TOPIC = "test";
//    public static final String JSON_TOPIC = "json";
//    public static final String DEFAULT_SERVER = "127.0.0.1:9092";
//    public static final String GROUP_1 = "group_1";
//    public static final String GROUP_2 = "group_2";
//    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfig.class);
//
//
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, DEFAULT_SERVER);
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_1);
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//
//        return new DefaultKafkaConsumerFactory<>(config);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }

//    @Bean
//    public ConsumerFactory<String, UserVo> userConsumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, DEFAULT_SERVER);
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_2);
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        // 告訴 JsonDeserializer 要用 UserVo 做解析
//        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, UserVo.class.getName());
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//
//        return new DefaultKafkaConsumerFactory<>(config);
//    }

    /**
     * 可用的
     *
     * @return
     */
//    @Bean
//    public ConsumerFactory<String, UserVo> userConsumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, DEFAULT_SERVER);
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_2);
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        JsonDeserializer<UserVo> jsonDeserializer = new JsonDeserializer(UserVo.class);
//        jsonDeserializer.addTrustedPackages("*");
//        /**
//         * 如果在另一個 project 的 UserVo 發送消息，會在 consumer 收到的時候，變成下面的樣子
//         * NO_HEADERS      null    { "id": "1", "name": "4" }                        > 這是用 CMD 發送，所以沒有 header
//         * __TypeId__:com.kafka.producer.UserVo    null    {"id":"s01","name":"sa"}  > 這是用 kafkaTemplate 發送，所以預設帶 TypeId
//         * 因此若可以確認 Deserialize 的物件，可以不啟用 TypeHeader 也就不用去抓 TypeId
//         */
//        jsonDeserializer.setUseTypeHeaders(false); // 禁用類型標識
//        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, jsonDeserializer);
//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), jsonDeserializer);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, UserVo> userKafkaListenerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, UserVo> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(userConsumerFactory());
//        return factory;
//    }

}