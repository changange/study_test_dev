package com.itany.producer;

import org.apache.kafka.common.serialization.Serializer;
//cn.hutool.json.JSONUtil
/**
 * Author：耿常安
 * Date：2021-03-22-7:52
 * Description：<描述>
 */
public class OtherSeriallizer implements Serializer<Other> {

    @Override
    public byte[] serialize(String s, Other data) {

        //return JSONUtil.toJSON(data).getBytes();
        return data.toString().getBytes();
    }
}
