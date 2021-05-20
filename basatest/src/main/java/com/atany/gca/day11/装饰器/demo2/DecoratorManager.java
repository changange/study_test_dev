package com.atany.gca.day11.装饰器.demo2;

/**
 * Author：耿常安
 * Date：2021-03-15-9:26
 * Description：<描述>
 */
public class DecoratorManager {
    private IDecorator decorator;

    private DecoratorManager(){
        decorator = new RandomIdDecorator(new RandomStrDecorator(null));
    }

    private static class ClassHolder{
        private static final DecoratorManager INSTANCE = new DecoratorManager();
    }

    public static DecoratorManager of(){
        return ClassHolder.INSTANCE;
    }

    public String replace(String str){
        return decorator.replace(str);
    }
}
