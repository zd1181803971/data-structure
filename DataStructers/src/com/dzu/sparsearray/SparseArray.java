package com.dzu.sparsearray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author by ZhaoDong
 * @Classname SparseArray
 * @Description 稀疏数组的转换
 * @Date 2021/8/30 23:13
 */
public class SparseArray {
    public static void main(String[] args) {
        HashMap<Integer, TempArray> map = new HashMap<>();
        int sum = 0;
        int[][] chessArr1 = new int[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                chessArr1[i][j] = i * j;
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                    map.put(sum, new TempArray(i, j, chessArr1[i][j]));
                }
            }
        }
        int[][] outArray = new int[sum + 1][3];
        outArray[0][0] = 11;
        outArray[0][1] = 11;
        outArray[0][2] = sum;
        for (int i = 1; i < sum + 1; i++) {
            TempArray tempArray = map.get(i);
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        outArray[i][j] = tempArray.getA();
                        break;
                    case 1:
                        outArray[i][j] = tempArray.getB();
                        break;
                    case 2:
                        outArray[i][j] = tempArray.getValue();
                        break;
                    default:return;
                }
            }
        }
        try {
            File file = new File("E:/123.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            StringBuilder stringBuilder = new StringBuilder(1024);
            for (int i = 0; i < sum + 1; i++) {
                for (int j = 0; j < 3; j++) {
                    stringBuilder.append(outArray[i][j]);
                    if (j != 2) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("\n");
            }
            outputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
