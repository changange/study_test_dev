package com.atany.gca.day11.装饰器.demo2;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author：耿常安
 * Date：2021-03-15-9:16
 * Description：<描述>
 */
public class RandomIdDecorator extends AbstractDecorator{

    Pattern pattern = Pattern.compile("randomId\\((\\d+)\\)");
    public RandomIdDecorator(IDecorator decorator) {
        super((AbstractDecorator)decorator);
    }

    @Override
    public String rep(String str) {
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()){
            String ss = matcher.group(0);
            //String len = matcher.group(1);
            int len = Integer.parseInt(matcher.group(1));
            //生成随机字符串
            String repalceStr = RandomStringUtils.randomNumeric (len);
            str = str.replace(ss, repalceStr);
        }

        return str;
    }
}
