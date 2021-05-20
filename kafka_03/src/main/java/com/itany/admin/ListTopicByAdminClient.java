package com.itany.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;

import java.util.Set;

/**
 * Author：耿常安
 * Date：2021-03-21-12:59
 * Description：<描述>
 */
public class ListTopicByAdminClient {

    public static void main(String[] args) {
        listDemo2();
    }

    public static void listDemo1(){
        try(AdminClient adminClient = MyKafkaAdminClient.createAdminClient();){
            ListTopicsResult result = adminClient.listTopics();     //查看topic
            Set<String> topicNameSet = result.names().get();
            System.out.println("topicNameSet+" + topicNameSet);

        }catch (Exception e){
            throw new IllegalStateException(e);
        }
    }

    public static void listDemo2(){
        MyKafkaAdminClient.createAdminClient(client->{
            ListTopicsResult result = client.listTopics();
            Set<String> topicNameSet = result.names().get();
            System.out.println("-----------------------");
            for(String s:topicNameSet){
                System.out.println("topic = " + s);
            }
            System.out.println("-----------------------");
        });
    }

    //待选项的展示topic   kafka自己内部维护
    public static void listDemo3(){
        MyKafkaAdminClient.createAdminClient(client->{
            ListTopicsOptions options = new ListTopicsOptions();
            options.listInternal(true);

            ListTopicsResult result = client.listTopics();
            Set<String> topicNameSet = result.names().get();
            System.out.println("-----------------------");
            for(String s:topicNameSet){
                System.out.println("topic = " + s);
            }
            System.out.println("-----------------------");
        });
    }
}
