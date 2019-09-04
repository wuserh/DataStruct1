package com.wh.divideAndConquer;

public class HanNuoTower {
    static int count = 0;

    public static void main(String[] args) {
        hanNuoTower(6, 'A', 'B', 'C');
        //System.out.println("次数：" + count);
        String s1 = "HelloWorld";
        String s2 = new String("HelloWorld");
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }
    }

    //汉诺塔问题,使用分治算法
    public static void hanNuoTower(int num, char a, char b, char c) {

        count++;
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "-》" + c);
        } else {
            //如果有n>=2,总是看作两个盘：1.最下面的一个盘2.上面的所有盘
            //1.把上面的所有盘移动到b,中间需要借助c
            hanNuoTower(num - 1, a, c, b);
            //2.把最下面的盘移动到c
            System.out.println("第" + num + "个盘从" + a + "-》" + c);
            //3.把上面所有的盘移动到c,移动过程借助于a
            hanNuoTower(num - 1, b, a, c);

        }
    }
}
