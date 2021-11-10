package com.dzu.recursion;

/**
 * @author by ZhaoDong
 * @Classname RecursionDemo
 * @Description 递归
 * @Date 2021/11/10 22:41
 */
public class RecursionDemo {
    public static void main(String[] args) {
        test(Integer.MAX_VALUE);
        test2(4);
        System.out.println();
        System.out.println(factorial(3));
    }

    // 打印问题
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println(n);
    }

    public static void test2(int n) {
        if (n > 2) {
            test2(n - 1);
        } else {
            System.out.println(n);
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
