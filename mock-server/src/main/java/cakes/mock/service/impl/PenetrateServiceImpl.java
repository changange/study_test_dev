package cakes.mock.service.impl;

import cakes.mock.model.MockConfig;
import cakes.mock.model.MockContext;
import cakes.mock.model.MockHeader;
import cakes.mock.service.PenetrateService;
import cn.hutool.http.HttpUtil;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-04-07-22:50
 * Description：<描述>
 */
@Service
public class PenetrateServiceImpl implements PenetrateService {

    private static final Logger LOGGER= LoggerFactory.getLogger(PenetrateServiceImpl.class);

    @Override
    public void handle(MockContext context) {
        MockConfig mockConfig = context.getTargetMockConfig();
        String penetrateUrl = mockConfig.getPenetrate();
        if (Strings.isNullOrEmpty(penetrateUrl)) {
            return;
        }

        //具体发送的请求相关的信息配置 比如：请求类型，请求头，各种请求的配置
        //content-type,method.........  都可以从 MockController的HttpServletRequest获取
        MockHeader header = context.getMockHeader();
        String methodType = header.getMethodType();

        LOGGER.info("Penetrate for method type = {}", methodType);
        String result=null;
        if (methodType.equals("POST")) {
            result = HttpUtil.post(penetrateUrl, context.getMockParameter().getParamMap()
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(entry -> entry.getKey(),
                            entry -> entry.getValue()))
            );
        }

        if (methodType.equals("GET")) {
            result = HttpUtil.get(penetrateUrl, context.getMockParameter().getParamMap()
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(entry -> entry.getKey(), Map.Entry::getValue))
            );
        }

        context.setTargetMockData(result);
    }
}
