package cakes.mock.decorator;

import cakes.mock.model.MockContext;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author：耿常安
 * Date：2021-04-07-8:55
 * Description： 改版之后需要的 hook
 */
public class HookParamDataDecorator extends AbstracMockDataDecorator{
    private static final Pattern pattern = Pattern.compile("\\$\\{hook:(.*)\\}");

    @Override
    protected String decoratee(String mockData, MockContext context) {
        if (Strings.isNullOrEmpty(mockData)) {
            return mockData;
        }

        Matcher matcher = pattern.matcher(mockData);
        while (matcher.find()){
            String originParam = matcher.group(0);
            String fieldName = matcher.group(1);

            String fieldValue = context.getMockParameter().getParamMap().get(fieldName);
            mockData = StringUtils.replace(mockData, originParam, fieldValue);
        }

        return mockData;
    }
}
