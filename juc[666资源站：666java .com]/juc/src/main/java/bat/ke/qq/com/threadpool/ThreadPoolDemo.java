package bat.ke.qq.com.threadpool;

import bat.ke.qq.com.MonkeyRejectedExecutionHandler;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();//快
        ExecutorService executorService2 = Executors.newFixedThreadPool(100);//慢
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();//最慢


        RejectedExecutionHandler rejectedExecutionHandler=  new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                // 写数据库的代码
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10));//自定义线程


        for (int i = 1; i <= 100; i++) {
//            executorService1.execute(new MyTask(i));
//            executorService2.execute(new MyTask(i));
//            executorService3.execute(new MyTask(i));
threadPoolExecutor.execute(new MyTask(i));
        }
    }
}

/***
 * 项目
 */
class MyTask implements Runnable {
    int i = 0;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "程序员做第" + i + "个项目");
        try {
            Thread.sleep(3000L);//业务逻辑
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(10);
        blockingQueue.add(1);
        blockingQueue.add(2);
        boolean offer = blockingQueue.offer(1);
        System.out.println(blockingQueue);
    }
}
