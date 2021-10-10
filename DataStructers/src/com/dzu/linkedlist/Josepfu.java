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
        list.countBoy(1, 2,5);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void build(int nums) {
        if (nums < 1) {
            System.out.println("nonono");
            return ;
        }

        Boy temp = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            // 一个节点
            if (i == 1) {
                first = boy;
                first.setNext(boy);
                temp = first;
            }else {
                // 让辅助指针向后移动，first指针不动
                // 辅助指针指向新的节点，新的节点指向first，辅助指针向后移动
                temp.setNext(boy);
                boy.setNext(first);
//                temp = temp.getNext();
                temp = boy;
            }
        }
    }

    public void countBoy(int startNo, int sums, int nums) {
        if (startNo < 1 || sums < 1 || nums < 1 || startNo > nums) {
            System.out.println("数据校验失败");
            return;
        }
        // 构建环形链表
        build(nums);
        Boy helper = first;
        // helper指向first的后yige
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 找出从第几个孩子开始数
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 只有一个节点返回
        // 否则都向后移动，此时first指向要出圈的，然后first后移一个，再让helper指向first
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < sums - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈顺序：" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后一个：" + first.getNo());

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
