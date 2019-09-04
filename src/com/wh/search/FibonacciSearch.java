package com.wh.search;

/**
 * 斐波那契查找，前提仍然是有序的数组
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        //int[] arr = {1, 8, 10, 89, 1000, 1234};

        //System.out.println("斐波那契：" + Arrays.toString(fib()));

    }

    //mid = low+F(k-1)-1需要使用到斐波那契数列，先获取一个斐波那契数列
    //使用非递归数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    /**
     * 斐波那契查找算法(非递归)
     *
     * @param arr 需要查找的数组
     * @param key 要找的数
     * @return 返回对应下标，没有返回-1
     */
//    public static int fibSearch(int[] arr, int key) {
//        int low = 0;
//        int high = arr.length - 1;
//        int k = 0;//表示斐波那契分割数值对应的下标
//        int mid = 0;//存放mid
//
//    }
}
