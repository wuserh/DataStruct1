package com.wh.search;

/**
 * 查找查找，也必须有序 int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 100 );
        System.out.println("插值查找："+index);
    }

    public static int insertValueSearch(int arr[], int left, int right, int findVal) {
        System.out.println("hello");

        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {//findVal < arr[0] || findVal > arr[arr.length-1]，小于最小的，大于最大的就中止，提高效率
                                                                                //必须这样，否则在找不存在的数据的时候会越界
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal < midVal) {//向左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) {
            //向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }


}
