package cakes.mock.decorator;

import cakes.mock.model.MockContext;

import java.util.Objects;

/**
 * Author：耿常安
 * Date：2021-04-05-13:56
 * Description： 装饰器 2
 */
public abstract class AbstracMockDataDecorator implements MockDataDecorator{

    private MockDataDecorator innerDecorator;

    //构造器
    public AbstracMockDataDecorator() {
    }

    public AbstracMockDataDecorator(MockDataDecorator innerDecorator) {
        this.innerDecorator = innerDecorator;
    }

    protected abstract String decoratee(String mockData, MockContext context);

    @Override
    public String decorate(String mockData, MockContext context) {

        //处理器一个套一个
        if (!Objects.isNull(this.innerDecorator)){
            String data = this.innerDecorator.decorate(mockData,context);
            return decoratee(data,context);
        }
        return decoratee(mockData,context);
    }
}
