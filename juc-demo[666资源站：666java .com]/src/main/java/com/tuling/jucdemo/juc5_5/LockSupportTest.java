package com.tuling.jucdemo.juc5_5;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {
        Thread parkThread = new Thread(new ParkThread());
        parkThread.start();

        parkThread.setName("1111");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread parkThread1 = new Thread(new ParkThread());
        parkThread1.start();
        parkThread1.setName("22222");

        System.out.println("唤醒parkThread");
        //为指定线程parkThread提供“许可”
        // 可以提前发许可。 需要的时候，直接就用了
        LockSupport.unpark(parkThread);
    }

    static class ParkThread implements Runnable{

        @Override
        public void run() {
            System.out.println("线程："+ Thread.currentThread().getName()+"ParkThread开始执行");
            // 等待“许可”
            LockSupport.park();
            System.out.println("线程："+ Thread.currentThread().getName()+"ParkThread执行完成");
        }
    }
}