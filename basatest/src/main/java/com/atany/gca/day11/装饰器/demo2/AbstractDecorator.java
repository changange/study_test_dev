package com.atany.gca.day11.装饰器.demo2;

/**
 * Author：耿常安
 * Date：2021-03-15-9:12
 * Description：<描述>
 */
public abstract  class AbstractDecorator implements IDecorator{
    private IDecorator decorator;

    public AbstractDecorator(AbstractDecorator decorator) {
        this.decorator = decorator;
    }

    public abstract String rep(String str);

    @Override
    public String replace(String str) {
        if (decorator !=null){
            str = decorator.replace(str);
        }
        return rep(str);
    }
}
