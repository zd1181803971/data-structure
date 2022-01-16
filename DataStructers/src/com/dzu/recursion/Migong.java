package com.dzu.recursion;


/**
 * @author by ZhaoDong
 * @Classname Migong
 * @Description 递归实现迷宫 、、 TODO 求出最短路径
 * @Date 2021/11/11 21:21
 */
public class Migong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 1 表示 围墙
        // 上下全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }



        // 设置障碍
        map[4][1] = 1;
        map[4][2] = 1;
        map[6][5] = 1;
        // 查看下 地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);

        System.out.println("======");
        // 输出新的地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 1、如果小球能到map[6][1]的位置，说明通路找到
     * 2、当map[i][j]为0表示该点没有走过，为1表示墙，2表示通路可以走 、3 表示该点已经走过，但是走不通
     * 3、走迷宫时，要指定一个策略（方法 ） 下、右、上、左，如果该点走不通，再进行回溯
     *
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到，返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        // 代表通路已经找到了，已经走到6.5位置了
        if (map[6][1] == 2) {
            System.out.println("找到");
            return true;
        } else {
            // 如果没有走过
            if (map[i][j] == 0) {
                // 假设这一条路可以走通
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 这条路走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }

    }

}
