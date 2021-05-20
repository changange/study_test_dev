package com.itany.admin;

import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;

import java.util.Arrays;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-21-13:59
 * Description：创建Topic
 */

public class CreateTopicByAdminClient {
    public static void main(String[] args) {
        MyKafkaAdminClient.createAdminClient(clinet ->{
            NewTopic topic = new NewTopic("gca",1,Short.parseShort("1"));
            // CreateTopicsResult re = clinet.createTopics(Collections.singletonList(topic));   //不知道和Arrays.List区别
            CreateTopicsResult re = clinet.createTopics(Arrays.asList(topic));

            Map<String, KafkaFuture<Void>> values = re.values();
            values.forEach((key,future) -> {
                System.out.println("key:" + key + "，future.isCompletedExceptionally()" + future.isCompletedExceptionally());
            });
        });
    }
}
