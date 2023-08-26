package com.qxlx.con;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;

/**
 * @author jiabaobao
 * @date 2023/4/10 10:15 PM
 */
public class CustomConsumer {

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"abc-1");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
       // properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"2000");

        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Arrays.asList("test1"));

        // 自动提交
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> c : consumerRecords) {
                System.out.printf("offset = %d, key = %s, values = %s%n",c.offset(),c.key(),c.value());
            }
            Thread.sleep(6000L);
            kafkaConsumer.commitAsync();
        }

        // 同步提交
//        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");
//        while (true) {
//            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(1));
//            //处理消息
//            try {
//                kafkaConsumer.commitSync();
//            } catch (Exception e) {
//                //处理异常
//                e.printStackTrace();
//            } finally {
//                kafkaConsumer.close();
//            }
//        }


//        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");
//        while (true) {
//            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(1));
//            //处理消息
//            try {
//                kafkaConsumer.commitAsync((offsets, exception) -> {
//                    if (Objects.nonNull(exception)) {
//                        //处理异常
//                    }
//                });
//            }  finally {
////                kafkaConsumer.close();
//            }
//        }


    }
}
