package cakes.mock.service.impl;

import cakes.mock.model.MockParameter;
import cakes.mock.service.HookParamsService;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author：耿常安
 * Date：2021-04-06-9:06
 * Description：<描述>
 */
@Service
public class HookParamsServiceImpl implements HookParamsService {
    private static final Pattern pattern = Pattern.compile("\\$\\{hook:(.*)\\}");

    @Override
    public String hook(String mockData, MockParameter mockParameter) {

        if (Strings.isNullOrEmpty(mockData)) {
            return mockData;
        }

        Matcher matcher = pattern.matcher(mockData);
        while (matcher.find()){
            String originParam = matcher.group(0);
            String fieldName = matcher.group(1);

            String fieldValue = mockParameter.getParamMap().get(fieldName);
            mockData = StringUtils.replace(mockData, originParam, fieldValue);
        }

        return mockData;
    }
}
