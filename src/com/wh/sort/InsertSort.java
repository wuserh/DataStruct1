package com.wh.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int arrs[] = {101, 36, 34, 119, 1};
        insertSort(arrs);

    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            //insertIndex >= 0，待插入的数有位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//将被插入的值赋给待插入的地方{101，101,119,1}
                insertIndex--;//-1
            }
            //退出while循环，说明插入的位置找到
            arr[insertIndex + 1] = insertVal;
        }
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));

//        //逐步分析法
//        //第一轮，{101,34,119,1}->{34,101,119,1}
//        //定义待插入的数及其下标
//        int insertVal = arr[1];//34待插入
//        int insertIndex = 1 - 1;//34待插入的位置
//
//        //insertIndex >= 0，待插入的数有位置
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];//将被插入的值赋给待插入的地方{101，101,119,1}
//            insertIndex--;
//        }
//        //退出while循环，说明插入的位置找到
//        arr[insertIndex + 1] = insertVal;
//
//
//        //第二轮{34,101,119,1}->{34,101,119,1}
//        //定义待插入的数及其下标
//        insertVal = arr[2];//119待插入
//        insertIndex = 2 - 1;//119待插入的位置
//
//        //insertIndex >= 0，待插入的数有位置
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];//将被插入的值赋给待插入的地方{101，101,119,1}
//            insertIndex--;
//        }
//        //退出while循环，说明插入的位置找到
//        arr[insertIndex + 1] = insertVal;
//
//
//        //第三轮{34,101,119,1}->{1,34,101,119}
//        //定义待插入的数及其下标
//        insertVal = arr[3];//1待插入
//        insertIndex = 3 - 1;//1待插入的位置
//
//        //insertIndex >= 0，待插入的数有位置
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];//将被插入的值赋给待插入的地方{101，101,119,1}
//            insertIndex--;
//        }
//        //退出while循环，说明插入的位置找到
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第3轮：");
//        System.out.println(Arrays.toString(arr));
//
    }

}



