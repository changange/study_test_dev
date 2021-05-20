package com.atany.gca.day11.监听器.demo2;

import com.atany.gca.day11.监听器.Tickket;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-15-22:51
 * Description：<描述>
 */

//单例
public class ObserverManager {
    private List<IObserver> observers;
    private ObserverManager(){
        observers = new ArrayList<>();
        observers.add(new QUna());
        observers.add(new XieC());
    }

    private static class ClassHolder{
        private static final ObserverManager INSTANCE = new ObserverManager();
    }

    public static ObserverManager of(){
        return ClassHolder.INSTANCE;
    }

    public void receive(Tickket tickket){
        for (IObserver observer:observers){
            observer.receive(tickket);
        }
    }
}
