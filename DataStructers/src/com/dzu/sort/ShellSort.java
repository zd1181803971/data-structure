package com.dzu.sort;

/**
 * @author ZhaoDong
 * @date 2022/2/26 17:06
 * @description 希尔排序。    插入排序增强版,也成为缩小增量排序
 * 希尔排序是把记录按下表的增量进行分组。对每组使用直接插入排序算法排序
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }

    /**
     * 移位法  很快
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for (int group = arr.length / 2; group > 0; group /= 2) {
            for (int i = group; i < arr.length; i++) {
                int index = i;
                int insertValue = arr[index];
                while (index - group >= 0 && insertValue > arr[index - group]) {
                    arr[index - group] = arr[index];
                    index -= group;
                }
                arr[index] = insertValue;
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
