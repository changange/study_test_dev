package com.itany.producer;

import org.apache.kafka.common.serialization.Serializer;
import org.kopitubruk.util.json.JSONUtil;
//cn.hutool.json.JSONUtil

/**
 * Author：耿常安
 * Date：2021-03-22-7:52
 * Description：JSON序列化器
 */
public class JsonSeriallizer<T> implements Serializer<T> {

    @Override
    public byte[] serialize(String s, T data) {
        return JSONUtil.toJSON(data).getBytes();
    }
}
