package com.itany.service;

import com.itany.entity.SyncDBInfo;
import com.itany.entity.SyncInfo;
import com.itany.entity.SyncTableInfo;

/**
 * Author：耿常安
 * Date：2021-03-11-10:39
 * Description：<描述>
 */
public interface SyncService {
    //同步实例
    void syncInstance(SyncInfo syncInfo);

    //同步DB
    void syncDB(SyncDBInfo syncDBInfo);

    //同步table
    void synTable(SyncTableInfo syncTableInfo);
}
