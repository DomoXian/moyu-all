package com.moyu.scheduer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by XianGuo
 * Date: 2017-07-18 22:00
 */
@Component
@Slf4j
public class TestScheduer {

    @Scheduled(fixedDelay = 6000)
    public void test(){
//        log.error("打印");
    }
}
