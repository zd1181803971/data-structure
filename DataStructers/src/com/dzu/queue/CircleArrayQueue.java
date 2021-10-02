package com.dzu.queue;

import java.util.Scanner;

/**
 * @author by ZhaoDong
 * @Classname CircleArrayQueue
 * @Description 环形的数组队列
 * @Date 2021/10/1 13:33
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            switch (str) {
                case "a":
                    System.out.println("输入添加的元素：");
                    int a = sc.nextInt();
                    circleArray.addQueue(a);
                    break;
                case "g":
                    System.out.println("获取一个元素");
                    System.out.println(circleArray.getQueue());
                    break;
                case "h":
                    System.out.println("队列头");
                    System.out.println(circleArray.getHead());
                    break;
                case "s":
                    System.out.println("展示队列");
                    circleArray.showQueue();
                    break;
                case "e":
                    System.out.println("退出");
                    System.exit(0);
                    break;

                default:
                    System.out.println("请输入正确的");
            }
        }
    }
}

class CircleArray{
    private int maxSize;
    /**
     * 指向元素第一个元素
     */
    private int font;

    /**
     * 指向元素最后一个元素的下一个位置，。
     * 希望能空出一个
     */
    private int real;
    public int[] array;

    public CircleArray(int initialCapacity) {
        maxSize = initialCapacity;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return (real + 1) % maxSize == font;
    }
    public boolean isEmpty() {
        return real == font;
    }
    public int size() {
        return (real + maxSize - font) % maxSize;
    }
    public int getHead() {
        if (isEmpty()) {
            System.out.println("数组空的");
            return -1;

        }
        return array[font];
    }
    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("数组已满");
            return;
        }
        array[real] = num;
        real = (real + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("数组空的");
            return -1;
        }
        int temp = array[font];
        font = (font + 1) % maxSize;
        return temp;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("数组空的");
            return;
        }
        for (int i = font; i < font + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, array[i % maxSize]);
        }
    }
}
