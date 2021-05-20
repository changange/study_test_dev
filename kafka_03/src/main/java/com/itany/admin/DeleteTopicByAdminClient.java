package com.itany.admin;

import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.common.KafkaFuture;

import java.util.Collections;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-21-21:53
 * Description： 删除topic
 */
public class DeleteTopicByAdminClient {

    public static void main(String[] args) {
        MyKafkaAdminClient.createAdminClient(client -> {
            DeleteTopicsResult resulgt = client.deleteTopics(Collections.singleton("hi_kafka"));
            Map<String, KafkaFuture<Void>> resultMap = resulgt.values();
            resultMap.forEach((topic,future)->{
                System.out.printf("topic=%s,res=%s \n",topic,future.isCompletedExceptionally());
            });
        });
    }
}
