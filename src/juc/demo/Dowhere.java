package juc.demo;

public class Dowhere {


    public static void main(String[] args) {
        dowhere();
    }

    private static void dowhere() {
        int a = 0;
        do {
            System.out.println(a);
            a += 1;
        } while (a < 10);
    }
}
