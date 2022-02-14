package com.dzu.sort;


/**
 * @author by ZhaoDong
 * @Classname BubbleSort
 * @Description 冒泡排序
 * @Date 2022/2/14 22:41
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 9, 4, 1};

        for (int i = 0; i < arr.length; i++) {
            boolean flog = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flog = false;
                }
            }
            if (flog) {
                break;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
