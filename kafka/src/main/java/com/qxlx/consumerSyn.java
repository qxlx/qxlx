package com.qxlx;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Objects;
import java.util.Properties;

/**
 * @author jiabaobao
 * @date 2023/4/3 10:27 PM
 */
public class consumerSyn {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        kafkaProducer.send(new ProducerRecord<>("test1", "aaa"),((metadata, exception) -> {
            if (Objects.nonNull(metadata)) {
                System.out.println("消息发送成功");
            }  else {
                System.out.println("消息发送失败");
            }
        }));
        kafkaProducer.close();
    }
}
