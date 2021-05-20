package cakes.mock.service.impl;

import cakes.mock.decorator.MockDataDecorateManager;
import cakes.mock.model.CallbackEntity;
import cakes.mock.model.MockContext;
import cakes.mock.service.CallbackService;
import cn.hutool.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-04-06-21:42
 * Description：<描述>
 */
@Service
public class CallbackServiceImpl implements CallbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackServiceImpl.class);

    private HookParamsServiceImpl hookParamsService;    //回调的参数，需要hookservice的值

    @Override
    public void callback(MockContext context) {
        CallbackEntity callback= context.getTargetMockConfig().getCallback();
        if (Objects.isNull(callback)) {
            return;
        }

        //处理 order的参数(orderId: ${radNum:8})
        //就是把地址栏的 radNum返回到控制台
        Map<String, Object> newParams = callback.getParams().entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> {

            //这里将参数的各种策略处理下
            //random, timestamp     请求的链接，随机生成一个串
            //处理hook
            return  MockDataDecorateManager.of().decorate(entry.getValue().toString(),context);
        }));

        System.out.println("回调函数------------------");
        String result = HttpUtil.post(callback.getUrl(), newParams);

        LOGGER.info("callback request = {}",result);
    }
}
