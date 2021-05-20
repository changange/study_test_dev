package cakes.mock.decorator;

import cakes.mock.model.MockContext;
import cakes.mock.util.DateUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Author：耿常安
 * Date：2021-04-05-14:05
 * Description：<描述>
 */
public class TimeStampMockDataDecorator extends AbstracMockDataDecorator{

    public TimeStampMockDataDecorator() {
    }

    public TimeStampMockDataDecorator(MockDataDecorator innerDecorator) {
        super(innerDecorator);
    }

    @Override
    protected String decoratee(String mockData, MockContext context) {
        return StringUtils.replace(mockData, "${timestamp}", DateUtils.getCurrentDataTime() + "");
    }
}
