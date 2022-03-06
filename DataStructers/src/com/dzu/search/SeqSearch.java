package com.dzu.search;

/**
 * @author ZhaoDong
 * @date 2022/3/6 13:01
 * @description 线性查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 5, 7};
        int i = seqSearch(arr, 5);
        System.out.println("i = " + i);
    }

    /**
     * 线性查找。
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
