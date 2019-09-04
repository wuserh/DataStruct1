package com.wh.queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }

    static class CircleArrayQueue {
        private int maxSize;//数组的最大容量

        private int front;
        private int rear;
        private int[] arr;

        public CircleArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = 0;//队列的头
            rear = 0;//队列的尾部的后一个位置******
        }

        //判断队列是否满
        public boolean isFull() {
            return (rear + 1) % maxSize == front;
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
            //直接将数据加入，因为初始为0
            arr[rear] = n;
            //将rear后移必须考虑取模
            rear = (rear + 1) % maxSize;
        }

        //取数据
        public int getQueue() {
            //判断是否为空
            if (isBank()) {
                //抛出异常
                throw new RuntimeException("数组越界");
            }
            //System.out.println("当前的front为：" + front);
            int temp;//定义一个临时变量
            temp = arr[front];//把front保留在临时变量里
            front = (front + 1) % maxSize;//front后移，同样考虑取模,【注】环形对了里面都是动态的
            return temp;
        }

        //显示数据
        public void showQueue() {
            //遍历
            if (isBank()) {
                System.out.println("队列为空，无数据");
                return;
            }
            //思路:从front开始遍历，遍历多少个元素【前面分析了：环形队列中有效元素的个数为：(rear + maxSize - front) % maxSize】
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n：", i % maxSize, arr[i % maxSize]);//这里显示取模
            }
        }

        //求出当前队列中的有效数据的个数
        public int size() {
            //rear = 3
            //front = 1
            //maxSize=5
            //表示2个元素，（3+5-1）%5=2
            return (rear + maxSize - front) % maxSize;

        }

        //显示队列头数据
        public int headQueue() {
            if (isBank()) {
                //抛出异常
                throw new RuntimeException("数组越界");
            }
            return arr[front];//不需要加1
        }

    }

}
