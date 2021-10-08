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
        list.showBoy();
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public Boy build(int nums) {
        if (nums < 1) {
            System.out.println("nonono");
            return null;
        }

        Boy temp = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(boy);
                temp = first;
            }else {
                temp.setNext(boy);
                boy.setNext(first);
//                temp = temp.getNext();
                temp = boy;
            }
        }
        return first;
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("null");
            return;
        }
        Boy temp = first;
        while (true) {
            System.out.println(temp.getNo());
            temp = temp.getNext();
            if (temp == first) {
                break;
            }
        }
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
