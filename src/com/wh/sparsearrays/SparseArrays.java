package com.wh.sparsearrays;

public class SparseArrays {
    public static void main(String[] args) {

        //创建一个元素的二维数组11X11
        //O表示没有棋子，1表示有黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始的二维数组：");
        for (int[] row : chessArr1) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }


        //将二维数组转为稀疏数组
        //1.遍历二维数组，得到非0的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("非0的个数：" + sum);

        //2.创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //从稀疏数组中恢复原二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //System.out.println("x:"+sparseArr[0][0]+"y:"+sparseArr[0][1]);
        //System.out.println("总:"+sparseArr.length);
        for (int k = 1; k < sparseArr.length; k++) {
            chessArr2[sparseArr[k][0]][sparseArr[k][1]] = sparseArr[k][2];
        }
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组:");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
