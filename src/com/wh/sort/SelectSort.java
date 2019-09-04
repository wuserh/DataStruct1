package com.wh.sort;


/**
 * 选择排序：
 * 1.选择排序一共有数组大小的-1轮排序
 * 2.每1轮排序，又是一个循环
 * 2.1假定当前这个数是最小的
 * 2.2然后和后面的数进行比较，如果有最小的，就重新确定最小的数和下标
 * 2.3当遍历到数组的最后时，就得到了本轮最小的数和下标
 * 2.4交换
 */
public class SelectSort {
    public static void main(String[] args) {


        int[] arrs = {};
    }

    public static void selectSort(int arr[]) {


        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minVal = arr[i];
            for (int j = i + 1; j < arr.length; j++) {//和第二个开始比较，比到最后
                if (minVal > arr[j]) {//如果假定的最小值大于比较的值,重置最小值和最小值的下标
                    minVal = arr[j];
                    minIndex = j;
                }
                arr[minIndex] = arr[i];
                arr[i] = minVal;
            }

/**
 //逐步分析推导：
 //原始数据：101，34,119，1
 //第一轮：1,34,119,101

 int minIndex = 0;
 int minVal = arr[0];
 for (int j = 0 + 1; j < arr.length; j++) {//和第二个开始比较，比到最后
 if (minVal > arr[j]) {//如果假定的最小值大于比较的值,重置最小值和最小值的下标
 minVal = arr[j];
 minIndex = j;
 }
 //将最小值放在arr[0]，以12,6为例,交换
 arr[minIndex] = arr[0];//将12的值放到arr[1]
 arr[0] = minVal;//将6放到arr[0]
 }

 //第二轮：1,34,119,101
 minIndex = 1;
 minVal = arr[1];
 for (int j = 1 + 1; j < arr.length; j++) {//和第二个开始比较，比到最后
 if (minVal > arr[j]) {//如果假定的最小值大于比较的值,重置最小值和最小值的下标
 minVal = arr[j];
 minIndex = j;
 }
 arr[minIndex] = arr[1];
 arr[1] = minVal;
 }


 //第三轮：1,34,101,119
 minIndex = 2;
 minVal = arr[2];
 for (int j = 2 + 1; j < arr.length; j++) {//和第二个开始比较，比到最后
 if (minVal > arr[j]) {//如果假定的最小值大于比较的值,重置最小值和最小值的下标
 minVal = arr[j];
 minIndex = j;
 }
 arr[minIndex] = arr[2];
 arr[2] = minVal;
 }
 */
        }
    }
}
