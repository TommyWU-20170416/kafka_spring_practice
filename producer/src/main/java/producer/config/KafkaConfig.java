package producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import producer.model.UserVo;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    public static final String JSON_TOPIC = "json";
    public static final String DEFAULT_SERVER = "127.0.0.1:9092";

    /**
     * 註冊一個 kafka producer 並指定 本機端、port、key、value、序列化方式
     * @return
     */
    @Bean
    public ProducerFactory<String, UserVo> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, DEFAULT_SERVER);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    /**
     * 作為包裝 producer，並提供便利的方法發送 topic
     * @return
     */
    @Bean
    public KafkaTemplate<String, UserVo> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    /**
     * Spring boot 註冊一個 KafkaAdmin，透過這個方法把 topic 新增到 kafka server topic 內
     * @return
     */
    @Bean
    public NewTopic defaultTopic() {
        return TopicBuilder.name(JSON_TOPIC).build();
    }
}
