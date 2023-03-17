package com.tuling.test;

public class Test {
    float version;

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public Test(float version) {
        this.version = version;
    }


    public static void main(String[] args) {
        Test test = new Test(1);
        System.out.println(test);
    }
}
