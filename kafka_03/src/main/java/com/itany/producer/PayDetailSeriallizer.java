package com.itany.producer;

import org.apache.kafka.common.serialization.Serializer;
import org.kopitubruk.util.json.JSONUtil;
//cn.hutool.json.JSONUtil

/**
 * Author：耿常安
 * Date：2021-03-22-7:52
 * Description：<描述>
 */
public class PayDetailSeriallizer implements Serializer<PayDetail> {

    @Override
    public byte[] serialize(String s, PayDetail payDetail) {

        return JSONUtil.toJSON(payDetail).getBytes();
        //return data.toString().getBytes();
    }
}
