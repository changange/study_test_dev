package com.itany;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Author：耿常安
 * Date：2021-03-20-13:14
 * Description：<描述>
 */
public class DataWatch implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("DataWatch.process====================="+watchedEvent);
    }
}
