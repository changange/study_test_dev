package cakes.auto.util;

import cn.hutool.http.HttpUtil;

import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-04-01-21:56
 * Description： Http
 *
 * 接口测试脚本
 * 一版本我们就是接口自动化测试  ....有点托大了，要把这些讲的说说才算是点
 */
public class AutoHttpClient {

    public static String doPost(String url, Map<String,Object > params){
        String resp = HttpUtil.post(url, params);
        return resp;
    }
}
