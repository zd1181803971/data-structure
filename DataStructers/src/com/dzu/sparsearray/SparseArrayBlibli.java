package com.dzu.sparsearray;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author by ZhaoDong
 * @Classname SparseArrayBlibli
 * @Description 将象棋转换为稀疏数组并写到磁盘
 * @Date 2021/9/5 21:33
 */
public class SparseArrayBlibli {
    public static void main(String[] args) {
        int h = 11, l = 11;

        int[][] chessArray = new int[h][l];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[3][4] = 1;
        chessArray[3][5] = 2;
        int sum = 0;
        System.out.println("象棋");
        for (int[] ints : chessArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        int[][] arraysNew = new int[sum + 1][3];
        arraysNew[0][0] = 11;
        arraysNew[0][1] = 11;
        arraysNew[0][2] = sum;

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    arraysNew[count][0] = i;
                    arraysNew[count][1] = j;
                    arraysNew[count][2] = chessArray[i][j];
                }
            }
        }

        StringBuilder builder = new StringBuilder(1024);
        for (int i = 0; i < arraysNew.length; i++) {
            builder.append(arraysNew[i][0]);
            builder.append("\t");
            builder.append(arraysNew[i][1]);
            builder.append("\t");
            builder.append(arraysNew[i][2]);
            builder.append("\n");
            System.out.printf("%d\t%d\t%d\n",arraysNew[i][0],arraysNew[i][1],arraysNew[i][2]);
        }

        File file = new File("E:/map.data");
        if (!file.exists()) {
            try {
               file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileInputStream = null;
        BufferedOutputStream bufferedInputStream = null;
        try {
             fileInputStream = new FileOutputStream(file);
             bufferedInputStream = new BufferedOutputStream(fileInputStream);
            bufferedInputStream.write(builder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.flush();
                bufferedInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
