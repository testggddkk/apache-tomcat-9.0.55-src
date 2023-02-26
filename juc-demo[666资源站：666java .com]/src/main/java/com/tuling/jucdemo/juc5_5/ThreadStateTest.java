package com.tuling.jucdemo.juc5_5;

import java.util.concurrent.locks.LockSupport;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Fox
 */
@Slf4j
public class ThreadStateTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        log.debug("线程状态：{}", thread.getState());
        thread.start();
        log.debug("线程状态：{}", thread.getState());
        Thread.sleep(100);
        log.debug("线程状态：{}", thread.getState());


    }
}
