package com.dzu.hashtable;

/**
 * @author by ZhaoDong
 * @Classname EmpLinkedList
 * @Description entry结点
 * @Date 2022/3/20 9:27
 */
public class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp current = head;
        while (current.next != null) {
            current = current.next;
        }
        if (current.id.equals(emp.id)) {
            System.out.println(emp.id + "：已经存在");
            return;
        }
        current.next = emp;
    }

    public void list(int no) {
        String str = "第" + no + "条链表内容为";
        if (head == null) {
            System.out.println(str + "null");
            return;
        }
        Emp current = head;
        System.out.print(str);

        while (true) {
            System.out.print("id: " + current.id + " name:" + current.name + "=>");

            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        System.out.println();
    }

    public Emp findById(String id) {
        if (head == null) {
            System.out.println("null");
            return null;
        }
        Emp current = head;
        while (true) {
            if (current.id.equals(id)) {
                break;
            }
            if (current.next == null) {
                current = null;
                break;
            }
            current = current.next;
        }
        return current;
    }
}
