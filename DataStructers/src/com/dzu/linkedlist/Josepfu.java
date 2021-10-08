package com.dzu.linkedlist;

/**
 * @author by ZhaoDong
 * @Classname Josepfu
 * @Description 约瑟夫
 * @Date 2021/10/8 21:53
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        Boy build = list.build(3);
        System.out.println(build);
    }
}

class CircleSingleLinkedList {
    private Boy first = new Boy(1);

    public Boy build(int nums) {
        if (nums < 1) {
            System.out.println("nonono");
            return null;
        }
        if (nums == 1) {
            first.setNext(first);
            return first;
        }
        Boy temp = first;
        for (int i = 2; i <= nums; i++) {
            Boy boy = new Boy(i);
            boy.setNext(first);
            temp.setNext(boy);
            temp = boy;
        }
        return first;
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
