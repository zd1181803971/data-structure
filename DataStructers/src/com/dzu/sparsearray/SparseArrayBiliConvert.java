package com.dzu.sparsearray;

import java.io.*;
import java.util.Arrays;

/**
 * @author by ZhaoDong
 * @Classname SparseArrayBiliConvert
 * @Description 读取稀疏数组并转换为象棋
 * @Date 2021/9/5 21:53
 */
public class SparseArrayBiliConvert {
    public static void main(String[] args) {
        int[][] chess = null;
        File file = new File("E:/map.data");
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s = bufferedReader.readLine();
                stringBuffer.append(s);
                String[] split = s.split("\t");
                chess = new int[Integer.parseInt(split[0])][Integer.parseInt(split[1])];
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    String[] strings = line.split("\t");
                    chess[Integer.parseInt(strings[0])][Integer.parseInt(strings[1])] = Integer.parseInt(strings[2]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(stringBuffer);


            for (int[] ints : chess) {
                for (int anInt : ints) {
                    System.out.printf("%d\t",anInt);
                }
                System.out.println();
            }

        }

    }
}
