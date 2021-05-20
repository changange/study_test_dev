package com.itany.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：耿常安
 * Date：2021-03-17-12:15
 * Description：<描述>
 */

@RestController
public class KafkaProducer {

    @Autowired
    private KafkaTemplate template;     //kafka模板

    //topic:主题  @RequestParam(defaultValue = "安安")默认主题
    //topic:如果发送的消息，主题不存在，会自动创建对应的主题
    @RequestMapping("/sendMsg")
    // public String sendMsg(@RequestParam(defaultValue = "安安")String topic, String messge){
        public String sendMsg(String topic, String messge){
        template.send(topic,messge);
        return "success";
    }

    @RequestMapping("/aa")
    public String sendTest(){
        return "是的";
    }

}
