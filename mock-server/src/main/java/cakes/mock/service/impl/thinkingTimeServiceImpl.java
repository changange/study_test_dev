package cakes.mock.service.impl;

import cakes.mock.model.MockContext;
import cakes.mock.model.TimeEntity;
import cakes.mock.service.thinkingTimeService;
import cn.hutool.core.thread.ThreadUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Author：耿常安
 * Date：2021-04-06-8:37
 * Description：<描述>
 */
@Service
public class thinkingTimeServiceImpl implements thinkingTimeService {
    @Override
    public void thinking(MockContext context) {
        TimeEntity timeEntity = context.getTargetMockConfig().getThinkingTime();
        if(Objects.isNull(timeEntity)){
            return;
        }

        ThreadUtil.sleep(timeEntity.getValue(),TimeUnit.valueOf(timeEntity.getUnit()));
    }
}
