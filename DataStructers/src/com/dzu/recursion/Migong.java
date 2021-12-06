package com.dzu.recursion;

/**
 * @author by ZhaoDong
 * @Classname Migong
 * @Description TODO
 * @Date 2021/11/11 21:21
 */
public class Migong {
    public static void main(String[] args) {
        test(()-> System.out.println("111"));
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");

            }
            num = 0;
        }
    }

    static void test(LambdaInterFace lambdaInterFace) {
        lambdaInterFace.f();
    }
}
