package com.itany.admin;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.admin.AlterConfigsResult;
import org.apache.kafka.clients.admin.Config;
import org.apache.kafka.clients.admin.ConfigEntry;
import org.apache.kafka.common.config.ConfigResource;

import java.util.Collections;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-21-22:05
 * Description：<描述>
 */
public class ConfigTopicByAdminClient {
    public static void main(String[] args) {

        MyKafkaAdminClient.createAdminClient(client -> {

            //指定要修改的源
            ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, "hello");
            //建立修改的配置项  修改成啥
            Config config = new Config(Collections.singleton(new ConfigEntry("preallocate", "true")));
            //参数构造
            Map<ConfigResource,Config> configs = Maps.newHashMap();
            configs.put(configResource,config);
            AlterConfigsResult result = client.alterConfigs(configs);

            result.all().get();

        });
    }
}
