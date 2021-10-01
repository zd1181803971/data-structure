package com.dzu.queue;

import java.util.Random;
import java.util.Scanner;

/**
 * @author by ZhaoDong
 * @Classname ArrayQueueDemo
 * @Description 通过数组实现队列（缺点：不是环形队列）
 * @Date 2021/9/11 15:21
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        char key = ' ';
        while (flag) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.show();
                    break;
                case 'a':
                    arrayQueue.add(new Random().nextInt());
                    break;
                case 'g':
                    System.out.println(arrayQueue.get());
                    break;
                default:
                    System.out.println("请输入正确命令！");

            }
        }
    }
}


class ArrayQueue {
    private static int maxSize;
    private static int head;
    private static int tail;
    private static int[] array;

    public ArrayQueue(int initialCapacity) {
        maxSize = initialCapacity;
        head = 0;
        tail = 0;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return tail == maxSize;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void add(int item) {
        if (isFull()) {
            throw new RuntimeException("满了");
        }
        array[tail++] = item;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("空的");
        }
        return array[head++];
    }

    public void show() {
        for (int i = 0; i < maxSize; i++) {
            System.out.println(array[i]);
        }
    }

}
