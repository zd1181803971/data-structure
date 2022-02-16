package com.book.datastruct.linear.array;

import java.util.Arrays;

/**
 * @author by ZhaoDong
 * @Classname LinearTable
 * @Description 数组 实现 线性表
 * @Date 2022/2/16 23:53
 */
public class LinearTable {
    private final String[] data;
    private final Integer maxSize;
    private Integer length;

    @Override
    public String toString() {
        return "LinearTable{" +
                "data=" + Arrays.toString(data) +
                ", maxSize=" + maxSize +
                ", length=" + length +
                '}';
    }

    public LinearTable(Integer maxSize) {
        this.data = new String[maxSize];
        this.maxSize = maxSize;
        this.length = 0;
    }

    /**
     * 删除第index位置上的元素
     * @param index 位置
     * @return
     */
    public String del(Integer index) {
        if (index < 1 || index > length) {
            return null;
        }
        String s = data[index - 1];

        for (int i = index; i < length; i++) {
            data[i - 1] = data[i];
        }
        length--;
        data[length] = null;
        return s;

    }
    /**
     * 在第index的位置插入str
     * @param index 位置
     * @param str 内容
     * @return
     */
    public boolean insert(Integer index, String str) {
        if (index < 1 || index >= maxSize) {
            return false;
        }

        if (index > length) {
            insert(str);
            return true;
        }

        for (int i = length; i >= index; i--) {
            data[i] = data[i - 1];
        }
        data[index - 1] = str;
        length++;
        return true;
    }

    /**
     * 获取第i位置的数据
     * @param i
     * @return
     */
    public String get(Integer i) {
        return data[i - 1];
    }

    /**
     * 插入str
     * @param str
     * @return
     */
    public void insert(String str) {
        data[length] = str;
        length++;
    }

    /**
     * 删除最后的一个
     * @return
     */
    public String del() {
        String s = data[length - 1];
        data[length - 1] = null;
        length--;
        return s;
    }
}
