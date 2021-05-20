package com.itany.producer;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Author：耿常安
 * Date：2021-03-21-23:10
 * Description：<描述>
 */
public class ProducerDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //为producer添加配置信息
        Map<String,Object> configs = Maps.newHashMap();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.16.1.35:9092");
        //configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        //这里或者用  Properties()
        //Properties configs1 = new Properties();
        //configs1.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");

        //创建KAfkaProducer
        Producer<String,String> producer = new KafkaProducer<>(configs);

        //创建一条kafka消息记录实体
        ProducerRecord<String, String> record = new ProducerRecord<>("hello", "nihao haha ");

        //发送
        Future<RecordMetadata> future = producer.send(record);

        //等待broker的ack，所以加了get的方式就是同步了。
        //不加这行代码，即不等待ack，此时就算是异步。依旧是不等待应答
        RecordMetadata metadata = future.get();
        System.out.println("ProducerDemo1.main = "+ metadata.offset());

        producer.close();
    }
}
