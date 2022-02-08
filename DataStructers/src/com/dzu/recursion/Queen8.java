package com.dzu.recursion;

/**
 * @author by ZhaoDong
 * @Classname Queen8
 * @Description 使用递归、解决八皇后问题
 * @Date 2022/2/8 21:16
 */
public class Queen8 {
    private static int count = 0;
    /**
     * 定义一个max表示多少个皇后
     */
    private static int MAX_QUEEN = 8;
    /**
     * 定义数组arr，保存皇后放置位置的结果；
     * 比如{0，4，7，5，2，6，1，3}，04752613
     * 表示  第一行 在第一列摆放。第二行在第五列摆放。第三行在第八列摆放。
     * 数组从零开始，所以现实中要加一
     */
    private static int[] ARR = new int[MAX_QUEEN];

    public static void main(String[] args) {
        System.out.println("===");
        new Queen8().check(0);
        System.out.println(count);
    }

    /**
     * 放置皇后，从第n开始
     * @param n
     */
    private void check(int n) {
        // 如果成功能放到第八个，就有一个成功的，进行打印
        if (n == MAX_QUEEN) {
            print();
            return;
        }
        // 再放置皇后时，每一列都要进行尝试放置
        for (int i = 0; i < MAX_QUEEN; i++) {
            // 假设能放，并且经过判断确实能放，则继续递归
            ARR[n] = i;
            if (judeg(n)) {
                check(n + 1);
                // 如果成功放到了第八个皇后，就会走打印方法。第八个皇后就进入下一列，再判断
                // 第八个皇后的for循环走完，也就是八列都放过了，再移动第七个皇后进入下一列，第八个皇后再重新放
            }
            // 如果判断失败，也就是真不能放，则继续将皇后放入下一列，在进行判断
        }
    }

    /**
     * 当我们放置第n个皇后时，判断该皇后与之前的皇后是否存在摆放冲突
     * 不能在一条线上（横竖斜
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judeg(int n) {
        for (int i = 0; i < n; i++) {
            // 先判断是否在同一列上（同一行无需判断，因为每次摆放皇后都是向上一行摆放
            if (ARR[i] == ARR[n]) {
                return false;
            }
            // 再判断是否在同意斜线上。通过对比x,y轴坐标的绝对值进行比较
            // 斜线正方向和斜线反方向,正方向对比坐标x-y，反方向对比坐标x+y
            // 同时判断需要判断；两个坐标轴的x的差值是否等于y的差值
            if (Math.abs(n - i) == Math.abs(ARR[n]- ARR[i]) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将皇后摆放的位置进行输出显示
     */
    private void print() {
        for (int i = 0; i < ARR.length; i++) {
            System.out.print(ARR[i] + "");
        }
        System.out.println();
        count++;
    }
}
