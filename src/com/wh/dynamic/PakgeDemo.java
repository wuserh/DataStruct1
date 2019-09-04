package com.wh.dynamic;

/**
 * 背包问题
 */
public class PakgeDemo {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4;//背包的容量
        int num = w.length;//物品的个数

        //创建二维数组
        //v[i][j]表示在前i个物品中，能够装入容量为j的背包的最大价值
        int[][] v = new int[num + 1][m + 1];

        //记录商品存放的情况，定义一个二维数组
        int[][] path = new int[num + 1][m + 1];

        //根据动态规划公式来处理，
        for (int i = 1; i < v.length; i++) {//从1开始不处理第一行
            for (int j = 1; j < v[0].length; j++) {//从1开始不处理第一列
                //公式
                if (w[i - 1] > j) {//新放入物品的容量大于背包总容量,因为是从1开始的，因此w中的i要修改为i-1
                    v[i][j] = v[i - 1][j];//容量不够直接用上次的放法
                } else {//因为是从1开始的，因此w中的i要修改为i-1,val[i]修改为i-1
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);

                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

//        //输出最后我们放入的是哪些商品，遍历path即可,这样输出的是所有的情况，但是我们只需要最后的放入
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[0].length; j++) {
//                if (path[i][j] == 1) {
//                    System.out.println("第" + i + "个商品放入到了背包中");
//                }
//            }
//        }
        int r = path.length - 1;//行的最大下标
        int c = path[0].length - 1;//列的最大下标

        while (r > 0 && c > 0) {//从path的最后开始找
            if (path[r][c] == 1) {
                System.out.println("第" + r + "个商品放入到了背包中");
                c -= w[r - 1];
            }
            r--;
        }


        //初始化第一行，第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//第一列都为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//第一行都为0
        }


    }
}
