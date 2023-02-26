package com.tuling.jucdemo.juc5_5;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Fox
 */
@Slf4j
public class ThreadExecuteTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // java 实现线程的方式  其实只有一种,  就是
        new Thread().start();
        // 创建线程干活，是需要  Runnable 接口实现来干活
//         Thread  这个类就是  实现了 Runnable 接口
//        FutureTask 这个类 实现了 RunnableFuture  接口  RunnableFuture 这个接口继承了  Runnable 接口
//                FutureTask 的构造函数有2个  Callable 和 Runnable
//                Callable



//
//        new Thread(new FutureTask<>(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                return null;
//            }
//        }));




        FutureTask futureTask=new FutureTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        },new Object());
        Object o = futureTask.get();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // 操作系统创建线程
        // java Thread --> jvm JavaThread---->os Thread

        // new Thread(runnable).start();
        // new Object()--->jvm JavaThread

//        Thread thread = new Thread(runnable);
//        log.debug("线程状态：{}", thread.getState());
//        thread.start();
//        log.debug("线程状态：{}", thread.getState());
//
//        // 这是一个真正的线程吗？  普通对象的方法调用
//        Thread thread1 = new Thread(runnable);
//        log.debug("线程1状态：{}", thread1.getState());
//        thread1.run();
//        log.debug("线程1状态：{}", thread1.getState());
//
//
//        runnable.run();


        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                log.debug("通过Callable方式执行任务");
                Thread.sleep(3000);
                return "返回任务结果";
            }
        });

        new Thread(task).start();
        log.debug("结果：{}",task.get());


//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        log.debug("monkey下班回家做饭");
//        Future<String> future = executor.submit(new Callable<String>() {
//            @Override
//            public String call() {
//                //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
//                log.debug("开始煮饭");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return "饭熟了";
//            }
//        });
//        Future<String> future2 = executor.submit(new Callable<String>() {
//            @Override
//            public String call() {
//                //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
//                log.debug("开始做菜");
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return "菜好了";
//            }
//        });
//
//        log.debug("{},{},monkey开始吃饭",future.get(), future2.get());
//
//        executor.shutdown();

    }
}
