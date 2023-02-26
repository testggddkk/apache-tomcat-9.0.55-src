package bat.ke.qq.com.threadpool;


import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);
        Task task = new Task("任务");
        //只 执行一次 。没啥意义
        System.out.println("Created : " + task.getName());
       // executor.schedule(task, 2, TimeUnit.SECONDS);
        //任务耗时+延迟   延迟2秒。任务10秒。那下次就是12秒后
//        executor.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);

        //  初始延迟时间 ， 固定延迟时间，  如果任务大于 调度时间，则按任务， 如果任务小于 周期时间，则按周期时间
        executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);//任延迟取最大值 稳定定时器

        //!!!! 任务里要 try catch

    }
}

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    AtomicInteger atomicInteger=new AtomicInteger();

    public void run() {

        if(true){
            throw  new NullPointerException();
        }
        System.out.println("Executing : " + name + ", Current Seconds : " + new Date().getSeconds());
        try {
            Random random=new Random();
            int i1 = random.nextInt(5);
            if(i1>0){
                System.out.println("任务执行时间是："+i1+"秒");
                Thread.sleep(i1*1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}