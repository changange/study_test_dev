package cakes.mock.service;

import cakes.mock.model.MockContext;

/**
 * Author：耿常安
 * Date：2021-04-03-10:06
 * Description： 通过哪种方式计算
 */
public interface SelectStrategyService {

    void selectMock(MockContext context);
}
