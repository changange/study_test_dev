package com.itany.producer;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Author：耿常安
 * Date：2021-03-22-7:44
 * Description：<描述>
 */
public class ProducerDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //为producer添加配置信息
        Map<String,Object> configs = Maps.newHashMap();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.16.1.35:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OtherSeriallizer.class.getName());

        //创建KAfkaProducer
        Producer<String, Other> producer = new KafkaProducer<>(configs);

        //创建一条kafka消息记录实体
        Other oder = new Other("帅an", 1024);
        ProducerRecord<String, Other> record = new ProducerRecord<>("hello", oder);

        //发送
        producer.send(record);

        producer.close();
    }
}
