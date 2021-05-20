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
public class RandomIdMockDataDecorator extends AbstracMockDataDecorator{

    static final Pattern pattern = Pattern.compile("\\$\\{radNum:(.?)\\}");

    public RandomIdMockDataDecorator() {
    }

    public RandomIdMockDataDecorator(MockDataDecorator innerDecorator) {
        super(innerDecorator);
    }

    @Override
    protected String decoratee(String mockData, MockContext context) {

        //${radNum:x} x=n 就是n个长度的随机数字
        //1、判断是否有radNum表示
        //2、拿到x具体是多少，是个数字
        //3、拿到数字，生成给定数字长度的数字串
        //4、替换 ${radNum:x}

        if (Strings.isNullOrEmpty(mockData)) {
            return mockData;
        }


        Matcher matcher = pattern.matcher(mockData);
        while (matcher.find()){
            String originNum = matcher.group(0);
            String originSLen = matcher.group(1);

            String randNum = RandomUtil.randomNumbers(Integer.parseInt(originSLen));
            mockData = StringUtils.replace(mockData, originNum, randNum);//替换
        }

        return mockData;
    }

    public static void main(String[] args) {
        RandomUtil.randomNumbers(8);
    }
}
