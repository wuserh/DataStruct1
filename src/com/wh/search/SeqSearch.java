package com.wh.search;

/**
 * 线性查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 5, 23, 32, 59};//无序数组
        System.out.println(seqSearch(arr, 32));
    }

    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }


}
