package com.dzu.sort;

import java.util.Arrays;

/**
 * @author ZhaoDong
 * @date 2022/2/26 17:06
 * @description 希尔排序。    插入排序增强版,也成为缩小增量排序
 * 希尔排序是把记录按下表的增量进行分组。对每组使用直接插入排序算法排序
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 希尔排序之 移位法
     * @param arr 要排序的数组
     */
    public static void shellSort2(int[] arr){
        //变量step为增量，并不断的缩小增量,直到缩小到1为止
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //对每次缩小的增量按照大小进行移位
            for (int i = step; i < arr.length ; i++) {
                //定义变量保存当前要比较的数值及其对应的索引
                int j = i;
                // 位移法是将小的数字提取出临时变量来，把大的数字依次往后移动，就是覆盖。通过对比前面的数子，找到最前面的位置后，再将小的数字赋值到最前面的位置，
                int tmp = arr[j];
                //如果当前数字小于前边一组对应的数字，则移位
                if (arr[j - step] > arr[j]) {
                    //循环寻找当前元素要插入的位置
                    while ((j - step) >= 0 && arr[j - step] > tmp) {
                        arr[j] = arr[j - step];
                        j -= step;
                    }
                    //则循环结束后找到要插入的位置
                    arr[j] = tmp;
                }
            }
        }

    }


    /**
     * 交换法  慢、
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int count = 0;
        // 根据数组长度分组
        for (int group = arr.length / 2; group > 0; group /= 2) {
            // 分组后，需要遍历的次数
            for (int i = group; i < arr.length; i++) {
                // 遍历各个组的所有元素、、 共(group组，每组（length/group)个元素），步长 group
                for (int j = i - group; j >= 0; j -= group) {
                    // 交换法 (比较笨,慢
                    // 每次进行比较，交换比自己大的数字。最终找不到比自己大的，就结束
                    if (arr[j] > arr[j + group]) {
                        int temp = arr[j];
                        arr[j] = arr[j + group];
                        arr[j + group] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮" + Arrays.toString(arr));
        }
    }
}
