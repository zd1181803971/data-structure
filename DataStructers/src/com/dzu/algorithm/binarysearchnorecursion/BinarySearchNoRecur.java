package com.dzu.algorithm.binarysearchnorecursion;

/**
 * @author ZhaoDong
 * @date 2022/5/22 17:24
 * @description 二分查找，不使用递归
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = binarySearchNoRecur(arr, 89);
        System.out.println(i);

    }

    public static int binarySearchNoRecur(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int min = (left + right) / 2;
            if (arr[min] == target) {
                return min;
            }
            if (target < arr[min]) {
                right = min - 1;
            }
            if (target > arr[min]) {
                left = min + 1;
            }
        }
        return -1;
    }
}
