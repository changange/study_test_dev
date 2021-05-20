package com.itany.entity;

import com.itany.util.VerifyUtil;
import lombok.Data;

/**
 * Author：耿常安
 * Date：2021-03-11-10:44
 * Description：<描述>
 */
@Data
public class SyncTableInfo extends SyncDBInfo {
    private String  dbName;
    private String tableName;

    @Override
    public void verify(){
        super.verify();
        VerifyUtil.verifyString(dbName,"dbName not null");
    }
}
