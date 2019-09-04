package com.wh.recursion;

/**
 * 八皇后问题思路：
 * 1.第一个皇后放第一行第一列
 * 2.第二个放在第二行第一列，判断是否ok,不ok的话，继续放第二列，第三列，。。。直到找到合适位置
 * 3.继续第三个皇后，和第二步一样，，直到第8个皇后也能放在合适的位置，得到正确的解
 * 4.当得到一个正确的解的时候，在栈回溯到上一个栈的时候，就会回溯，即将第一个皇后，放到第一列的所有正确解，得到所有
 * 5.然后回头继续第一个皇后放第二列，后面循环执行1,2,3，4
 */
public class EightQueens {

    int MAX = 8;
    int[] array = new int[MAX];//array下标代表行，值代表列

    static int count = 0;

    public static void main(String[] args) {
        EightQueens queue = new EightQueens();

        queue.check(0);
        System.out.println("共" + count + "种解法");

    }


    //放置第n个皇后
    //注意，check是每一次递归，进入check都有 for (int i = 0; i < MAX; i++),因此会回溯
    private void check(int n) {
        if (n == MAX) {//此时n=8,表示放低9个皇后，意味着前8个皇后都放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < MAX; i++) {//i每加一个就向后挪一列
            //先把这个皇后放在该行的第一列
            array[n] = i;
            //判断放置的第n个皇后到第i列时候，是否与前n-1冲突
            if (judge(n)) {//不冲突,接着放第n+1个，即开始递归
                check(n + 1);
            }
            //如果冲突，返回array[n] = i执行;此时i增加了1，即将第n个皇后放在本行的后移的一个位置
        }

    }

    //判断n是否和前n-1行冲突
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //Math.abs(n - i) == Math.abs(array[n] - array[i]判断是否在同一斜线，array下标代表行，值代表列，所以可以用这个公式判断
            //array[i] == array[n]判断是否在同一列
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
