package com.itany.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-03-17-12:22
 * Description：<描述>
 */

@Component  //交给springboot
public class KafkaConsumer {

    //监听主题,订阅多个主题
    //订阅的主题一定要有，不然那报错（如：hello和aaa）
    // @KafkaListener(topics = {"hello","aaa"})
    @KafkaListener(topics = {"hello"})
    //Deserializer:主题订阅的消息
    public void listen(ConsumerRecord record){
        // System.out.println(record);

        System.out.println(record.topic()+"：" +record.value());
    }
}
