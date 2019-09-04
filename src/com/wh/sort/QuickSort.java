package com.wh.sort;

import java.util.Arrays;

/**
 *
 */

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {-9, 78, 0, 40, -5, 12, -8, 23, 67, -21, 3, 7, 2, -322};
        //int arr[] = {-9, 78, 0, 40, -567, 70, -1, 900, 4561};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排完后的：" + Arrays.toString(arr));

    }

    public static void quickSort(int arr[], int left, int right) {
        int l = left;//左下标
        int r = right;//由下标
        int pivot = arr[(left + right) / 2];//中轴值
        int temp;
        while (l < r) {
            //在pivot左边一直找，直到找到大于等于pivot,退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot右边一直找，直到找到小于等于pivot,退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果左边大于等于右边，说明pivot两边的值：左边小于pivot,右边大于pivot
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现arr[l] == pivot,r--,前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现arr[r] == pivot,l--,后移
            if (arr[r] == pivot) {
                l += 1;
            }

            //如果l==r，必须l--,r++,否则，；会导致栈溢出
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //左递归
            if (left < r) {
                quickSort(arr, left, r);
            }
            //右递归
            if (right > l) {
                quickSort(arr, l, right);
            }
        }
    }
}
