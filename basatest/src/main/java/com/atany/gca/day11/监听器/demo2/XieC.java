package com.atany.gca.day11.监听器.demo2;

import com.atany.gca.day11.监听器.Tickket;

/**
 * Author：耿常安
 * Date：2021-03-15-22:45
 * Description：<描述>
 */
public class XieC implements IObserver {
    @Override
    public void receive(Tickket tickket){
        System.out.println("XieC.receive：" + tickket);
    }
}
