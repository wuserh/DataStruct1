package com.wh.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        int[] arr2 = {1, 2, 3, 4, 5};

        int[] arr1 = {2, 6, 5, 3, 9, 1};
//        //生成8000个数据
//        int[] arrays = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arrays[i] = (int) (Math.random() * 8000000);
//        }
//        //测试时间
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
//        String s1 = simpleDateFormat.format(date);
//        System.out.println("排序前的时间： " + s1);
//
//        bubbleSort(arrays);
//
//        //System.out.println(Arrays.toString(arr));//总的
//        Date date1 = new Date();
//        String s2 = simpleDateFormat.format(date1);
//        System.out.println("排序后的时间： " + s2);
        bubbleSort(arr1);

    }

    private static void bubbleSort(int[] arr) {
        int temp;
        //优化
        boolean flag = false;//标识符，标志是否进行交换
        //System.out.println("特殊的：" + arr.length);
        for (int i = 0; i < arr.length - 1; i++) {//int arr[] = {3, 9, -1, 10, 20}，5个数，数组长度为5，比较0,1,2,3四次i<5-1
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;//进入交换，置为true
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;//没有交换，中断循环
            } else {//进行了交换，重新置位false,下次再判断
                flag = false;
            }

            System.out.println("第" + (i + 1) + "趟排序的结果为"+ Arrays.toString(arr));
//            System.out.println(Arrays.toString(arr2));
        }
    }

}
