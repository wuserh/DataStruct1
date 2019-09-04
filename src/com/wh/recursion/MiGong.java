package com.wh.recursion;

public class MiGong {

    static int count = 0;

    public static void main(String[] args) {

        //先创建一个迷宫地图
        //用二维数组创建
        int[][] map = new int[8][7];
        //1表示墙，上下位墙,左右也为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

//        map[1][2] = 1;
//        map[2][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println("********新的地图*******");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        //System.out.println("找了" + count + "次");
    }

    //使用递归回溯来给小球找路

    /**
     * @param map,地图
     * @param i      从哪里开始找
     * @param j
     * @return 找到通路，返回true,否则返回false
     * 说明：ij从（1,1）出发，如果能找到map[i][j],则说明通路找到
     * map[i][j]为0，表示该点没有走过，当表示1，表示为墙，2表示通路，3表示该路已经走过，但是走不通
     * 规定走的策略，下-》右-》上-》左，如果走不通，再回溯
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;//通路找到
        } else {
            if (map[i][j] == 0) {//当前点没有走到
                //假定当前点可以走通
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {//说明该点不通，为3
                    map[i][j] = 3;
                    return false;
                }

            } else {//如果map[i][j]不等于0，可能为1,2,3
                return false;
//                if (map[i][j] == 1) {
//                    map[i][j] = 3;
//                    return false;
//                } else if (map[i][j] == 2) {
//
//                    return true;
//                }

            }
        }
    }
}
