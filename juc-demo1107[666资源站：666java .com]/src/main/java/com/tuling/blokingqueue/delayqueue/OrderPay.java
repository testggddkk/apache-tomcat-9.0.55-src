package com.tuling.blokingqueue.delayqueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟订单支付，创建订单
 */
public class OrderPay {

    static String[] str = new String[]{ "成功", "支付中", "订单初始化" };

    public static String getTime(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        String currentTime = formatter.format(date);
        return currentTime;
    }

    public static void main(String[] args) throws InterruptedException {
        OrderOverTimeClose.getInstance().init();

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    // 创建初始订单
                    long createTime = System.currentTimeMillis();
                    String currentTime = getTime(createTime);
                    //设置订单过期时间
                    String overTime = getTime(createTime + 10000);// 10s后超时
                    String orderNo = String.valueOf(new Random().nextLong());
                    OrderInfo order = new OrderInfo();
                    order.setOrderNo(orderNo);
                    order.setExpTime(overTime);
                    int random_index = (int) (Math.random() * str.length);
                    //设置订单状态
                    order.setStatus(str[random_index]);
                    order.setCreateTime(currentTime);
                    //插入订单到延时队列中
                    OrderOverTimeClose.getInstance().orderPutQueue(order, currentTime, overTime);
                }
            };
            service.execute(run);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}