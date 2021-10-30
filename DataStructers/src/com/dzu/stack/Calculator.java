package com.dzu.stack;

/**
 * @author by ZhaoDong
 * @Classname Calculator
 * @Description 栈实现综合计算器 TODO 加入（）
 * @Date 2021/10/13 21:40
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-2";
        // 创建两个栈，一个数栈，一个操作符栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的变量
        int index = 0; // 用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepNumber = "";
        char ch = ' ';// 将每次扫描得到的char保存到ch上

        // while循环扫描expression
        while (true) {
            // 依次得到每一个字符  bug:两位数就办不了了
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是数字还是字符，然后做相应处理
            if (operStack.isOper(ch)) {
                // 判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    // 如果符号栈中不为空，就要进行比较。
                    // 如果当前的操作符的优先级 小于等于 栈中的操作符，就需要从数栈中pop出两个数，进行运算
                    // 将运算结果push到数字栈。再将操作符push到符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //  如果当前的操作符的优先级 大于 栈中的操作符，直接入栈
                        operStack.push(ch);
                    }
                } else {
                    // 如果 操作符栈为空  直接入栈
                    operStack.push(ch);
                }
            } else {
                // 如果是数字
//                numStack.push(ch - 48); // 此时 ch = '1'，字符'1'对应的ASCII码表中为49，所以要减去48
                // FIX BUG:处理多位数
                keepNumber += ch;
                // 如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNumber));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNumber));
                        // 重要！！！！拼接用的字符串 要 清空！！
                        keepNumber = "";
                    }
                }
            }
            // 最后让 index + 1，然后判断是否到expression最后
            index++;
            if (index == expression.length()) {
                break;
            }
        }
        // 当表达式扫描结束，就顺序的从操作符栈和数栈中pop出相应的数字和操作符，进行计算

        while (true) {
            // 如果操作符栈为空，则计算到了最后的结果了，是数栈中只有一个的数字
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(res);
    }
}

class ArrayStack2 {
    private int top = -1;
    private int max;
    private int[] stack;

    public ArrayStack2(int max) {
        this.max = max;
        stack = new int[max];
    }

    /**
     * 返回运算符的优先级
     *
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
     *
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
     *
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

    /**
     * 可以查看当前栈顶的值，但不是真正的pop
     *
     * @return
     */
    public int peek() {
        return stack[top];
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
