package cakes.mock.service.impl;

import cakes.mock.decorator.MockDataDecorateManager;
import cakes.mock.model.MockContext;
import cakes.mock.service.DynamicStralegyService;
import org.springframework.stereotype.Service;

/**
 * Author：耿常安
 * Date：2021-04-05-13:26
 * Description：<描述>
 */

@Service
public class DynamicStralegyServiceImpl implements DynamicStralegyService {
    @Override
    public void handleMock(MockContext context) {
        //时间戳处理
        //{errNo: 2000,errMsg: "SUCCESS1",data: {userId: "1234",userName: "gcas","createTime":${currentTime}}}
        //String result = StringUtils.replace(mockData, "${currentTime}", DateUtils.getCurrentDataTime() + "");

        //随机ID处理    （装饰器模式去写）
        //${radNum:x} x=n,就是n个长度的随机字符串

        //.....

        String mockData = MockDataDecorateManager.of().decorate(context.getTargetMockData() ,context);
        context.setTargetMockData(mockData);
    }
}
