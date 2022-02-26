package com.dzu.sort;

import java.util.Arrays;

/**
 * @author ZhaoDong
 * @date 2022/2/26 15:21
 * @description 插入排序
 *      分为 有序表和无序表，无序表向有序表插入数据
 *      尾插，最大的数在最末尾。每次插入首先和末尾比较，大于末尾则直接尾插。否则依次向前比价
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 11};
        insertSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int insertValue = arr[i + 1];
            int index = i;
            // 从大到小排序 改变 insertValue 和 arr[index} 值的对比
            while (index >= 0 && insertValue < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            // 此处判断必要性不大
            if (index != i) {
                arr[index + 1] = insertValue;
            }
        }
    }
}
