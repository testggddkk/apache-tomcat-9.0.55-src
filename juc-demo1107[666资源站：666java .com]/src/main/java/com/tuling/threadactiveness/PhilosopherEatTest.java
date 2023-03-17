package com.tuling.threadactiveness;

import com.tuling.jucdemo.threadactiveness.Chopstick;
import com.tuling.jucdemo.threadactiveness.Philosopher;

/**
 * @author Fox
 * 哲学家就餐问题
 */
public class PhilosopherEatTest {

    public static void main(String[] args) {

        //初始化五根筷子
        com.tuling.jucdemo.threadactiveness.Chopstick c1 = new com.tuling.jucdemo.threadactiveness.Chopstick(1);
        com.tuling.jucdemo.threadactiveness.Chopstick c2 = new com.tuling.jucdemo.threadactiveness.Chopstick(2);
        com.tuling.jucdemo.threadactiveness.Chopstick c3 = new com.tuling.jucdemo.threadactiveness.Chopstick(3);
        com.tuling.jucdemo.threadactiveness.Chopstick c4 = new com.tuling.jucdemo.threadactiveness.Chopstick(4);
        com.tuling.jucdemo.threadactiveness.Chopstick c5 = new Chopstick(5);
        // 思考： 如何打破循环
        new com.tuling.jucdemo.threadactiveness.Philosopher("苏格拉底", c1, c2).start();
        new com.tuling.jucdemo.threadactiveness.Philosopher("柏拉图", c2, c3).start();
        new com.tuling.jucdemo.threadactiveness.Philosopher("亚里士多德", c3, c4).start();
        new com.tuling.jucdemo.threadactiveness.Philosopher("赫拉克利特", c4, c5).start();
        new Philosopher("阿基米德", c1,c5).start();

    }
}
