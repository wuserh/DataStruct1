package com.wh.search;

import java.util.ArrayList;

/**
 * 二分查找，前提是该数组必须有序的(这个很重要的)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1000, 1000, 1000};
        ArrayList index = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("找到的下标为：" + index);
    }

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 需要查找的值
     * @return 如果找到，返回下边，没有找到，返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {//当left>right，说明递归整个数组，都没有找到，返回-1；
            return -1;
        }
        if (findVal > midVal) {//要找得值大于中间值，向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }


    /**
     * 如果数组中有多个相同的值，要求返回所有的下标
     * 思路：找到mid不要马上返回，分别向mid的左右扫描，找到一个放入ArrayList
     * 最后返回ArrayList
     */

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {//当left>right，说明递归整个数组，都没有找到，返回-1；
            return new ArrayList<>();
        }
        if (findVal > midVal) {//要找得值大于中间值，向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndex = new ArrayList<>();

            int temp = mid - 1;
            while (true) {
                System.out.println("test");
                if (temp < 0 || arr[temp] != findVal) {
                    System.out.println("进入break");
                    break;
                }

                resIndex.add(temp);
                System.out.println("test1");
                temp--;
            }
            resIndex.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndex.add(temp);
                temp++;
            }


            return resIndex;
        }
    }

}
