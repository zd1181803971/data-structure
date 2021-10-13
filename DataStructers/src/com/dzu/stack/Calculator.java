package com.dzu.stack;

/**
 * @author by ZhaoDong
 * @Classname Calculator
 * @Description 栈实现综合计算器
 * @Date 2021/10/13 21:40
 */
public class Calculator {
    public static void main(String[] args) {

    }
}
class ArrayStack2{
    private int top = -1;
    private int max;
    private int[] stack;

    public ArrayStack2(int max) {
        this.max = max;
        stack = new int[max];
    }

    /**
     * 返回运算符的优先级
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 2;
        } else if (oper == '+' || oper == '-') {
            return 1;
        } else {
            return -1;
        }
    }


    /**
     * 判断是否是一个运算符
     * @param val
     * @return
     */
    public boolean isOper(char val) {
        String oper = "+-*/";
        String s1 = String.valueOf(val);
        if (oper.contains(s1)) {
            return true;
        }
        return false;
    }

    /**
     * 计算方法
     * @param num1 出栈的数，也就是后进来的
     * @param num2 出栈的第二个数，也就是先进来的
     * @param oper 操作符
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                return -1;
        }
        return res;
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
