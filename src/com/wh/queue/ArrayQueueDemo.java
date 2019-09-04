package com.wh.queue;

import sun.rmi.runtime.Log;

import java.util.Scanner;

/**
 * 目前的数组使用一次就不能 使用。没有复用
 * 需改为环形队列%
 */

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key;//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s：显示队列");
            System.out.println("e：退出队列");
            System.out.println("a：增加数据到队列");
            System.out.println("g：从队列中取数据");
            System.out.println("h：显示队列头部数据");
            key = scanner.next().charAt(0);//表示接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数据：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':

                    int res = arrayQueue.getQueue();
                    try {
                        System.out.println("取出的数据为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    int headRes = arrayQueue.headQueue();
                    try {
                        System.out.println("队列的头部的数据为：" + headRes);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");
    }


    //使用数组模拟队列
    //1.编写一个ArrayQueue类
    static class ArrayQueue {
        private int maxSize;//数组的最大容量

        private int front;
        private int rear;
        private int[] arr;

        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;//队列的头的前一个位置******
            rear = -1;//队列的尾部
        }

        //判断队列是否满
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        //判断队列是否为空
        public boolean isBank() {
            return front == rear;
        }

        //添加数据到队列
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满");
                return;
            }
            rear++;// 尾部后移.因为初始为-1
            arr[rear] = n;//
        }

        //取数据
        public int getQueue() {
            //判断是否为空
            if (isBank()) {
                //抛出异常
                throw new RuntimeException("数组越界");
            }
            front++;
            System.out.println("当前的front为：" + front);
            return arr[front];
        }

        public void showQueue() {
            //遍历
            if (isBank()) {
                System.out.println("队列为空，无数据");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n：", i, arr[i]);
            }
        }

        //显示队列头数据
        public int headQueue() {
            if (isBank()) {
                //抛出异常
                throw new RuntimeException("数组越界");
            }
            return arr[front + 1];
        }
    }
}
