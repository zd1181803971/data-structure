package com.test;

import com.dzu.sort.InsertSort;
import com.dzu.sort.ShellSort;

/**
 * @author ZhaoDong
 * @date 2022/2/27 15:45
 * @description data-structure
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long l = System.currentTimeMillis();

        ShellSort.shellSort2(arr);

        System.out.println("耗费时间" + (System.currentTimeMillis() - l));

    }
}
