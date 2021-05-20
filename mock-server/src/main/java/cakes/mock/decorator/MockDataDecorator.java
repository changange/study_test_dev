package cakes.mock.decorator;

import cakes.mock.model.MockContext;

/**
 * Author：耿常安
 * Date：2021-04-05-13:54
 * Description：装饰器 1
 */
public interface MockDataDecorator {
    String decorate(String mockData, MockContext context);
}
