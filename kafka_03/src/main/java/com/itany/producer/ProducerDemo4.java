package com.itany.producer;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Author：耿常安
 * Date：2021-03-22-7:44
 * Description： 异步、同步、回调
 */
public class ProducerDemo4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //为producer添加配置信息
        Map<String,Object> configs = Maps.newHashMap();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSeriallizer.class.getName());

        //创建KAfkaProducer
        Producer<String, PayDetail> producer = new KafkaProducer<>(configs);

        //创建一条kafka消息记录实体
        PayDetail detail = new PayDetail("ID123",System.currentTimeMillis(),1027L);
        ProducerRecord<String, PayDetail> record = new ProducerRecord<>("hello-kafka", detail);

        //发送
        //异步同步、回调、都在这里处理，几种处理方式，分别对应的就是我们所说的异步同步、回调

        //1、同步  future.get(); 这里会阻塞
        Future<RecordMetadata> future = producer.send(record);
        future.get();

        //2、异步
        producer.send(record);

        //3、异步加回调、这里不会阻塞程序执行
        //有了结果在回调
        producer.send(record, (metadata,exception)->{
            System.out.println("metadata = " + metadata);
            System.out.println("exception = " + exception);;
        });

        System.out.println("-------其他逻辑--------");

        producer.close();
    }
}
