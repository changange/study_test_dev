package cakes.mock.decorator;

import cakes.mock.model.MockContext;
import cn.hutool.core.util.RandomUtil;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author：耿常安
 * Date：2021-04-05-14:05
 * Description：<描述>
 */
public class RandomNumMockDataDecorator extends AbstracMockDataDecorator{

    static final Pattern pattern = Pattern.compile("\\$\\{radId:(.+?)\\}");

    public RandomNumMockDataDecorator() {
    }

    public RandomNumMockDataDecorator(MockDataDecorator innerDecorator) {
        super(innerDecorator);
    }

    @Override
    protected String decoratee(String mockData, MockContext context) {


        if (Strings.isNullOrEmpty(mockData)) {
            return mockData;
        }


        Matcher matcher = pattern.matcher(mockData);
        while (matcher.find()){
            String originNum = matcher.group(0);
            String originSLen = matcher.group(1);

            String randNum = RandomUtil.randomString(Integer.parseInt(originSLen));
            mockData = StringUtils.replace(mockData, originNum, randNum);//替换
        }

        return mockData;
    }
}
