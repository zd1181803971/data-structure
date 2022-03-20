package com.dzu.hashtable;

/**
 * @author by ZhaoDong
 * @Classname HashTabDemo
 * @Description 哈希表代码实现
 * @Date 2022/3/20 9:27
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(6);
        Emp emp = new Emp();
        emp.id = "qwe1";
        emp.name = "tom";

        Emp emp2 = new Emp();
        emp2.id = "qwe3";
        emp2.name = "tom";

        Emp emp3 = new Emp();
        emp3.id = "qwe5";
        emp3.name = "tom";
        hashTable.add(emp);
        hashTable.add(emp2);
        hashTable.add(emp3);

        hashTable.list();

        System.out.println(hashTable.find("qwe5"));

    }
}
