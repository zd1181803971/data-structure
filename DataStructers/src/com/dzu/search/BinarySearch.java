package com.dzu.search;

/**
 * @author ZhaoDong
 * @date 2022/3/6 13:04
 * @description 二分查找 TODO 优化+插值查找
 * waring:  使用二分查找，该数组必须是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = binarySearch(arr, 0, arr.length - 1, 6666);
        System.out.println("i = " + i);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (findVal == arr[mid]) {
            return mid;
        }

        if (findVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findVal);
        }
        if (findVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findVal);

        }

        return -1;
    }
}
