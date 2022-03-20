package com.dzu.hashtable;

/**
 * @author by ZhaoDong
 * @Classname HashTable
 * @Description 哈希表
 * @Date 2022/3/20 9:40
 */
public class HashTable {
    private final EmpLinkedList[] empLinkedListArray;
    private final int size;

    public HashTable(int size) {
        this.empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
    }

    public void add(Emp emp) {
        int i = tableSizeFor(emp.id);
        if (empLinkedListArray[i] == null) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
        empLinkedListArray[i].add(emp);
    }

    private int tableSizeFor(String id) {
        return id.hashCode() % size;
    }
    public void list() {
        for (int i = 0; i < empLinkedListArray.length; i++) {
            if (empLinkedListArray[i] == null) {
                continue;
            }
            empLinkedListArray[i].list(i + 1);
        }
    }

    public Emp find(String id) {
        int i = tableSizeFor(id);
        return empLinkedListArray[i].findById(id);
    }
}
