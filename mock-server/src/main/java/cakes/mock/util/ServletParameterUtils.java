package cakes.mock.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-04-07-11:05
 * Description：<描述>
 */
public class ServletParameterUtils {

    public static Map<String, String> getParam(HttpServletRequest servletRequest) {
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();

        Map<String, String> paraMap = parameterMap.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(),
                entry -> handleParamForArray(entry.getValue())));

        return paraMap;
    }


    private static String handleParamForArray(String[] args){
        if (Objects.isNull(args) || args.length == 0) {
            return "";
        }

        return args[0];
    }
}
