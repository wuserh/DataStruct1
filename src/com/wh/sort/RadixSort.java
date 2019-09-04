package com.wh.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基数（桶）排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println("归并排序后=" + Arrays.toString(arr));

    }

    public static void radixSort(int[] arr) {

        //根据推导，写出最终的基数排序的代码
        //1.得到数组中最大的数的位数
        int maxValue = arr[0];
        for (int m = 0; m < arr.length; m++) {
            if (arr[m] > maxValue) {
                maxValue = arr[m];
            }
        }

        for (int i = 0; i < String.valueOf(maxValue).length(); i++) {
            //或(int i = 0;n=1 i < String.valueOf(maxValue).length(); i++;n*=10)
            //定义一个二维数组，表示10个（桶）一位数组
            int[][] bucket = new int[10][arr.length];
            //为了记录每个桶中的数据，定义一个维数组来记录每个桶的每次放入的数据个数
            //例bucketElementCounts[0]表示记录bucket[0]种每次放入的数据个数
            int[] bucketElementCounts = new int[10];

            //第i轮，针对每个元素的个十百...位进行排序
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个/十/百...位的值
                int digitOfElement = arr[j] / ((int) Math.pow(10, i)) % 10;
                //或int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //按照桶的顺序，（一维数组的下标依次取出数据，放入原来的数组中）
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入原数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，放入原数组中
                if (bucketElementCounts[k] != 0) {//说明有数据
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理后，需要将记录每个桶中元素个数的数组bucketElementCounts[k]清零
                //******
                bucketElementCounts[k] = 0;
            }
            //System.out.println("第" + (i + 1) + "轮排序后的顺序：" + Arrays.toString(arr));


        }

//+++++++++++++++++++++=========== 逐步推导   ==========================================================


//        //定义一个二维数组，表示10个（桶）一位数组
//        int[][] bucket = new int[10][arr.length];
//        //为了记录每个桶中的数据，定义一个维数组来记录每个桶的每次放入的数据个数
//        //例bucketElementCounts[0]表示记录bucket[0]种每次放入的数据个数
//        int[] bucketElementCounts = new int[10];
//
//        //第一轮，针对每个元素的个位进行排序
//        for (int j = 0; j < arr.length; j++) {
//            //取出每个元素的个位的值
//            int digitOfElement = arr[j] /1% 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照桶的顺序，（一维数组的下标依次取出数据，放入原来的数组中）
//        int index = 0;
//        //遍历每一个桶，并将桶中的数据放入原数组中
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据，放入原数组中
//            if (bucketElementCounts[k] != 0) {//说明有数据
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放到arr
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//
//            //第一轮处理后，需要将记录每个桶中元素个数的数组bucketElementCounts[k]清零
//            //******
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第一轮排序后的顺序：" + Arrays.toString(arr));
//
//
//        //第二轮，针对每个元素的十位进行排序
//        for (int j = 0; j < arr.length; j++) {
//            //取出每个元素的十位的值
//            int digitOfElement = arr[j] / 10 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照桶的顺序，（一维数组的下标依次取出数据，放入原来的数组中）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据放入原数组中
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据，放入原数组中
//            if (bucketElementCounts[k] != 0) {//说明有数据
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放到arr
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            //第二轮处理后，需要将记录每个桶中元素个数的数组bucketElementCounts[k]清零，不然会出现数组越界错误
//            //******
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第二轮排序后的顺序：" + Arrays.toString(arr));
//
//
//        //第三轮，针对每个元素的百位进行排序
//        for (int j = 0; j < arr.length; j++) {
//            //取出每个元素的百位的值
//            int digitOfElement = arr[j] / 100 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照桶的顺序，（一维数组的下标依次取出数据，放入原来的数组中）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据放入原数组中
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据，放入原数组中
//            if (bucketElementCounts[k] != 0) {//说明有数据
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放到arr
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//        }
//        System.out.println("第三轮排序后的顺序：" + Arrays.toString(arr));
//
//
    }

}
