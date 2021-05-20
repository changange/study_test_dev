package com.itany.admin;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Author：耿常安
 * Date：2021-03-21-11:56
 * Description：<描述>
 */
public class MyKafkaAdminClient {

    public static void main(String[] args) {
        AdminClient client = createAdminClient();
        System.out.println("client == " + client);

    }

    public static AdminClient createAdminClient(){
        Map<String,Object> conf = Maps.newHashMap();
        conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"172.16.1.35:9092");
        AdminClient client = AdminClient.create(conf);

        return client;
    }

    // public static AdminClient createAdminClient(Consumer<AdminClient> consumer){
    //    Map<String,Object> conf = Maps.newHashMap();
    //    conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"172.16.1.35:9092");
    //    AdminClient client = AdminClient.create(conf);
    //    //这是个钩子，在这里勾一下，勾的是client对象，谁用谁勾，在这里完成具体的基于AdminClient的操作
    //    consumer.accept(client);
    //    //在这里自己完成client关闭操作，一般建议下面的方式
    //    client.close();
    //
    //    return client;
    // }

    public static AdminClient createAdminClient(AdminClientConsumer consumer) {
        Map<String, Object> conf = Maps.newHashMap();
        conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.1.35:9092");

        try (AdminClient client = AdminClient.create(conf);) {
            consumer.accept(client);
            return client;
        } catch (InterruptedException e) {   //中断
            System.err.println("get result by interrupted");
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
