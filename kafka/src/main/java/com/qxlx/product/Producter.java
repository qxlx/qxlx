package com.qxlx.product;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @author jiabaobao
 * @date 2023/4/3 10:27 PM
 */
public class Producter {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"abc-1");

        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);

        kafkaProducer.initTransactions();
        kafkaProducer.beginTransaction();
        try {
            for (int i = 0; i < 5; i++) {
                RecordMetadata recordMetadata = kafkaProducer.send(new ProducerRecord<>("test1", "aaa" + i)).get();
                System.out.println(recordMetadata);
            }
//            int i = 1 / 0;
            kafkaProducer.commitTransaction();
        } catch (Exception e) {
            kafkaProducer.abortTransaction();
            e.printStackTrace();
        }

        kafkaProducer.close();
    }
}
