package com.wh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 */
public class MergetSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2}; //

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    //分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }


    //合并的方法

    /**
     * @param arr   待排序的数组
     * @param left  数组的初始索引
     * @param mid   中间索引 （右边的初始）
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //System.out.println("合并的次数");
        int i = left;//初始化i,左边序列的初始索引
        int j = mid + 1;//初始化j，右边序列的初始索引
        int t = 0;//temp的当前索引

        //<1>
        //先把左右两边的数据按照规则填充到temp数组
        //直到左右两边的有序序列其中有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {//如果左边有序序列的当前元素小于或等于右边的，就把数据填充到temp中，然后t后移，i后移
                temp[t] = arr[i];
                t++;
                i++;
            } else {//反之将右边有序序列的当前元素填充到temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //<2>
        //把剩余数组的一边数据依次填充到temp数组中
        while (i <= mid) {//说明左边有剩余,就全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //<3>
        //将temp数组的元素拷贝到arr中*******
        //并不是每次都拷贝全部
        t = 0;
        int tempLeft = left;
        //第一次合并：tempLeft=0，right = 1;第二次合并tempLeft=2，right = 3，第三次合并：tempLeft=0，right = 3
        //最后一次：tempLeft=0，right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }

}
