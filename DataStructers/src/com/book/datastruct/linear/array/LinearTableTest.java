package com.book.datastruct.linear.array;

/**
 * @author by ZhaoDong
 * @Classname LinearTableTest
 * @Description 线性表测试
 * @Date 2022/2/17 0:03
 */
public class LinearTableTest {
    public static void main(String[] args) {
        LinearTable table = new LinearTable(10);

        table.insert("qwe");
        table.insert("123");
        System.out.println(table);
        table.insert(2, "zd");
        System.out.println(table);

        System.out.println(table.del(2));

        System.out.println(table);

    }
}
