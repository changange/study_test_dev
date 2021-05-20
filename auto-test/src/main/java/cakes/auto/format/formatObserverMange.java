package cakes.auto.format;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-24-21:56
 * Description：枚举定义单例
 */
public enum formatObserverMange {

    INSTANCE;

    private List<FormatObserver> observers;

    formatObserverMange(){
        //具体的格式化处理目前有3个
        //1、AutoTest本身的三个属性
        //2、Checkpoint的非空判断
        //3、Warning的判断处理
        this.observers= Lists.newArrayList(
                new CommonFormatObserver(),
                new CheckpointsFormatObserver(),
                new WarningsFormatObserver()
        );
    }

    public static formatObserverMange of(){
        return INSTANCE;
    }

    //维护所有的 observers
    public void format(FormatContext context){
        for (FormatObserver observer:this.observers){
            observer.update(context);
        }
    }
}
