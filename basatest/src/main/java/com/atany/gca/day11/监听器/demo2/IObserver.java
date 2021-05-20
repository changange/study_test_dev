package com.atany.gca.day11.监听器.demo2;

import com.atany.gca.day11.监听器.Tickket;

/**
 * Author：耿常安
 * Date：2021-03-15-22:49
 * Description：<描述>
 */
public interface IObserver {
    void receive(Tickket tickket);
}
