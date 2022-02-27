package com.dzu.sort;

/**
 * @author by ZhaoDong
 * @Classname SelectSort
 * @Description 选择排序   相比 冒泡排序 速度更快
 * @Date 2022/2/15 20:49
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 3, 1, 10, 9};
        selectSort(arr);
    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
