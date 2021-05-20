package cakes.mock.service.impl;

import cakes.mock.model.MockContext;
import cakes.mock.model.MockHeader;
import cakes.mock.model.MockParameter;
import cakes.mock.service.ParameterResolveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-04-03-9:19
 * Description： 参数解析实现类
 */

@Service
public class ParameterResolveServiceImpl implements ParameterResolveService {


    @Override
    public void resolve(MockContext context) {
        HttpServletRequest httpRequest = context.getHttpRequest();

        //String[]-->String
        Map<String, String[]> parameterMap = httpRequest.getParameterMap();
        Map<String, String> paraMap = parameterMap.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(),
                entry -> handleParamForArray(entry.getValue())));

        MockParameter parameter = new MockParameter();
        parameter.setMockUri(StringUtils.substringAfter(httpRequest.getRequestURI(),"/"));
        parameter.setParamMap(paraMap);
        parameter.setRequestHost(httpRequest.getRemoteHost());

        context.setMockParameter(parameter);

        //透传
        MockHeader header = new MockHeader();
        header.setContentTupe(httpRequest.getContentType());
        header.setMethodType(httpRequest.getMethod());

        context.setMockHeader(header);
    }

    private static String handleParamForArray(String[] args){
        if (Objects.isNull(args) || args.length == 0) {
            return "";
        }

        return args[0];
    }
}
