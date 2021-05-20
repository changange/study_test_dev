package com.itany.consumer;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-22-8:46
 * Description：<描述>
 */
public class ConsumerDemo1 {

    public static void main(String[] args) {
        Map<String,Object> configs = Maps.newHashMap();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG,"test"); //消息组
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");    //自动提交
        configs.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");//提交间隔

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(configs);

        //订阅消息
        kafkaConsumer.subscribe(Collections.singleton("hello-kafka"));

        while (true){
            //接受消息、不断地轮训
            //Duration.ofMillis(100)：超时时间
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
            System.out.println("ConsumerDemo1.main = " + records);

            //kafkaConsumer.commitSync(); //手动提交，收完消息自动提交，异步提交
            kafkaConsumer.commitAsync();//同步提交，拿到broker的反馈，回调   才执行下一步
        }

    }
}
