package com.dzu.stack;

/**
 * @author by ZhaoDong
 * @Classname LinkedListStackDemo
 * @Description 通过单链表的方式实现栈
 * @Date 2021/10/11 22:26
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedStackTest test = new LinkedStackTest();
        test.buildStack(5);
        test.push(123);
        test.push(1232);
        test.show();
    }
}

class LinkedStackTest {
    private LinkedStack head = new LinkedStack(-1);

    public void buildStack(int maxNode) {
        LinkedStack temp = head;
        for (int i = 0; i < maxNode; i++) {
            LinkedStack linkedStack = new LinkedStack(i);
            temp.setNext(linkedStack);
            temp = linkedStack;
        }
    }

    public void push(int value) {
        LinkedStack temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        LinkedStack linkedStack = new LinkedStack(value);
        temp.setNext(linkedStack);
    }
    public Integer pop() {
        if (head.getNext() == null) {
            System.out.println("empty");
            return null;
        }
        LinkedStack temp = head;
        while (true) {
            if (temp.getNext() == null) {
                int val = temp.getVal();
                temp.setNext(null);
                return val;
            }
            temp = temp.getNext();
        }
    }

    public void show() {
        if (head.getNext() != null) {
            LinkedStack temp = head.getNext();
            showNode(temp);
        }

    }
    // 递归的方式反向输出链表（或者头插法）
    private void showNode(LinkedStack node) {
        while (true) {
            if (node == null) {
                return;
            }
            showNode(node.getNext());
            System.out.println(node.getVal());
            return;
        }
    }
}

class LinkedStack {
    private LinkedStack next;
    private int val;

    public LinkedStack(int val) {
        this.val = val;
    }


    public LinkedStack getNext() {
        return next;
    }

    public void setNext(LinkedStack next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
