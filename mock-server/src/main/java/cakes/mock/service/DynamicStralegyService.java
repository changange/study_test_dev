package cakes.mock.service;

import cakes.mock.model.MockContext;

/**
 * Author：耿常安
 * Date：2021-04-05-13:23
 * Description： 动态策略server（如：时间戳）
 */
public interface DynamicStralegyService {

    void handleMock(MockContext context);
}
