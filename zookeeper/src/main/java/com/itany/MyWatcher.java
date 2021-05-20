package com.itany;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Author：耿常安
 * Date：2021-03-18-18:53
 * Description：<描述>
 */

//监视器
public class MyWatcher implements Watcher {

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("MyWatcher.process----------"+watchedEvent);
    }
}
