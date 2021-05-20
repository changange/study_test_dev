package com.atany.gca.day11.监听器.demo1;

import com.atany.gca.day11.监听器.Tickket;

/**
 * Author：耿常安
 * Date：2021-03-15-22:43
 * Description：<描述>
 */
public class AirC {
    public void send(Tickket tickket){
        new QUna().receive(tickket);
        new XieC().receive(tickket);
    }
}
