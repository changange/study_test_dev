package cakes.mock.decorator;

import cakes.mock.model.MockContext;

/**
 * Author：耿常安
 * Date：2021-04-05-14:08
 * Description： 用枚举实现单例
 */
public enum MockDataDecorateManager {

    INSTANG;

    private MockDataDecorator mockDataDecorator;

    MockDataDecorateManager()   {

        HookParamDataDecorator hookParamDataDecorator = new HookParamDataDecorator();
        RandomIdMockDataDecorator randomIdMockDataDecorator = new RandomIdMockDataDecorator(hookParamDataDecorator);
        RandomNumMockDataDecorator randomNumMockDataDecorator = new RandomNumMockDataDecorator(randomIdMockDataDecorator);
        this.mockDataDecorator = new TimeStampMockDataDecorator(randomNumMockDataDecorator);

        // this.mockDataDecorator = new TimeStampMockDataDecorator(
        //         new RandomNumMockDataDecorator(
        //                 new RandomIdMockDataDecorator(
        //                         new HookParamDataDecorator()
        //                 )
        //         )
        // );
    }

    public static MockDataDecorateManager of(){
        return  INSTANG;
    }

    public String decorate(String mockData, MockContext context){
        return this.mockDataDecorator.decorate(mockData,context);
    }
}
