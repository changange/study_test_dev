package com.itany.controller;

import com.itany.entity.RetMsg;
import com.itany.entity.SyncDBInfo;
import com.itany.entity.SyncInfo;
import com.itany.entity.SyncTableInfo;
import com.itany.service.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：耿常安
 * Date：2021-03-11-10:46
 * Description：<描述>
 */
@RestController
@RequestMapping("/sync")
@Slf4j
public class SynscController {

    private SyncService syncService;

    @RequestMapping("/instance")
    //@RequestBody    通过json传参
    public RetMsg sync(@RequestBody SyncInfo syncInfo){
        try {
            //1、参数校验
            syncInfo.verify();
            //2、业务调用（service）
            syncService.syncInstance(syncInfo);

            return RetMsg.success();
        }catch (Exception e){
            log.info("exception{}",e);
            return RetMsg.error("122","参数校验失败");
        }
    }

    @RequestMapping("/db")
    //@RequestBody    通过json传参
    public RetMsg sync(@RequestBody SyncDBInfo syncDBInfo){
        try {
            //1、参数校验
            syncDBInfo.verify();
            //2、业务调用（service）
            syncService.syncDB(syncDBInfo);

            return RetMsg.success();
        }catch (Exception e){
            log.info("exception{}",e);
            return RetMsg.error("122","参数校验失败");
        }
    }

    @RequestMapping("/table")
    //@RequestBody    通过json传参
    public RetMsg sync(@RequestBody SyncTableInfo syncTableInfo){
        try {
            //1、参数校验
            syncTableInfo.verify();
            //2、业务调用（service）
            syncService.synTable(syncTableInfo);

            return RetMsg.success();
        }catch (Exception e){
            log.info("exception{}",e);
            return RetMsg.error("122","参数校验失败");
        }
    }
}
