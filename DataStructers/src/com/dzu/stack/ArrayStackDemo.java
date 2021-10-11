package com.dzu.stack;

import java.util.Scanner;

/**
 * @author by ZhaoDong
 * @Classname ArrayStackDemo
 * @Description 用数组模拟栈
 * @Date 2021/10/11 22:02
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayStack arrayStack = new ArrayStack(4);
        while (true) {
            String next = scanner.next();
            switch (next) {
                case "a":
                    arrayStack.push(scanner.nextInt());
                    break;
                case "b":
                    Integer pop = arrayStack.pop();
                    System.out.println(pop);
                    break;
                case "s":
                    arrayStack.show();
                    break;
                default:
                    System.out.println("=====");
            }
        }
    }
}
class ArrayStack{
    private int top = -1;
    private int max;
    private int[] stack;

    public ArrayStack(int max) {
        this.max = max;
        stack = new int[max];
    }

    public boolean isFull() {
        return max == top - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int node) {
        if (isFull()) {
            System.out.println("FULL");
            return;
        }
        top++;
        stack[top] = node;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return null;
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }

}

