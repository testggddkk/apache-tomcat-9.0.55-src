package com.tuling.jucdemo.jmm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fox
 */
public class Test {

    private volatile static int sum = 0;
    //    static Object object = "";
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
//                synchronized (object) {
                reentrantLock.lock();
                for (int j = 0; j < 10000; j++) {
                    sum++;
                }
                reentrantLock.unlock();
//                }
            });
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum);

    }

}
