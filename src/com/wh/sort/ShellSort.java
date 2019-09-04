package com.wh.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);


//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            for (int i = gap; i < arr.length; i++) {
//                for (int j = i - gap; j >= 0; j -= gap) {
//                    if (arr[j] > arr[j + gap]) {
//                        int temp = arr[j + gap];
//                        arr[j + gap] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }
//        System.out.println("排序后的大小：" + Arrays.toString(arr));

    }


    //逐步推导
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有元素，共gap组，每组?个，步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {

                    if (arr[j] > arr[j + gap]) {//如果当前元素大于加上步长后的元素，则交换
                        temp = arr[j + gap];//交换法
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }

                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(arr));

//        //希尔排序第一轮：第一轮将10个数据分为5组
//        for (int i = 5; i < arr.length; i++) {
//            //遍历各组中所有元素，共5组，每组2个，步长为5
//            for (int j = i - 5; j >= 0; j -= 5) {
//                if (arr[j] > arr[j + 5]) {//如果当前元素大于加上步长后的元素，则交换
//                    temp = arr[j + 5];
//                    arr[j + 5] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println("第一轮排序后：" + Arrays.toString(arr));
//
////希尔排序第二轮：第一轮将10个数据分为5/2=2组
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有元素步长为2
//            for (int j = i - 2; j >= 0; j -= 2) {
//                if (arr[j] > arr[j + 2]) {//如果当前元素大于加上步长后的元素，则交换
//                    temp = arr[j + 2];
//                    arr[j + 2] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println("第二轮排序后：" + Arrays.toString(arr));
//
//
//
//        //希尔排序第三轮：第一轮将10个数据分为2/2=1组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有元素步长为2
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (arr[j] > arr[j + 1]) {//如果当前元素大于加上步长后的元素，则交换
//                    temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println("第三轮排序后：" + Arrays.toString(arr));

    }


    public void shellSortMove(int arr[]) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出循环表示找到了位置
                    arr[j] = temp;

                }

//                for (int j = i - gap; j >= 0; j -= gap) {
//
//
//                }

            }

        }


    }

}
