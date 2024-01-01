package producer.control;

import producer.config.KafkaConfig;
import producer.model.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate<String, UserVo> kafkaTemplate;

    @GetMapping("/publish/{dpt}/{id}")
    public String post(@PathVariable("dpt") final String dpt, @PathVariable("id") final String id) {

        UserVo userVo = new UserVo(id, dpt);
        kafkaTemplate.send(KafkaConfig.JSON_TOPIC, userVo);
        System.out.println();
        return "Published doneeeeeeeee";
    }
}