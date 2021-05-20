package com.itany.mvc.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Author：耿常安
 * Date：2021-03-07-22:28
 * Description：     定时任务
 */

@Slf4j
@Component
public class PrintTime {

    @Scheduled(cron = "*/5 * * * * *")      //秒分时日月
    private void printTime(){
        log.info("time={}", LocalDateTime.now());
    }
}
