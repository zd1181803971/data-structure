package com.dzu.algorithm.dac;

/**
 * @author ZhaoDong
 * @date 2022/5/22 16:34
 * @description 分治算法解决汉诺塔
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        // 如果只有一个盘，A->C
        if (num == 1) {
            System.out.println("第" + num + "个盘从" + a + "->" + c);
        } else {
            // 如果n>=2个盘，我们总可以看作是两个盘 1、最下面的盘，2、上面的盘
            // 先把最上面的盘 A->B
            hanoiTower(num - 1, a, c, b);
            // 最下面的盘 A-> C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            // 把B塔的所有的盘从 B->C
            hanoiTower(num - 1, b, a, c);
        }
    }

}
