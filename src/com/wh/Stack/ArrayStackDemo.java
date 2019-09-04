package com.wh.Stack;

public class ArrayStackDemo {


    public static void main(String[] args) {

    }
}


class ArrayStack {

    private int maxSize;//栈的大小
    private int[] stack;//数组，存放栈的数据

    int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//初始化栈
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int push() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空，无法遍历");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("数据：" + stack[i]);
        }

    }


}
