package com.wh.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {
    private ArrayList<String> vertexList;//存放顶点的List

    private int[][] edges;//存储图对应的临接矩阵

    private int numOfEdges;//表示边的数目

    //定义一个Boolean[]数组，记录某个结点是否被访问
    private boolean isVisited[];

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(getMod(num));

//        int n = 5;
//        String verVal[] = {"A", "B", "C", "D", "E"};
//        Graph graph = new Graph(n);
//        for (String item : verVal) {//循环添加对象
//            graph.insertVertex(item);
//        }
//
//        graph.insertEdges(0, 1, 1);//AB
//        graph.insertEdges(0, 2, 1);//AC
//        graph.insertEdges(1, 2, 1);//BC
//        graph.insertEdges(1, 3, 1); //BD
//        graph.insertEdges(1, 4, 1); //BE
//
//        graph.showGraph();
    }

    //返回余数
    public static String getMod(int nums) {
        StringBuilder result = new StringBuilder();

        while (true) {
            //System.out.println("测试数：" + nums);
            if (nums ==0) {//23->2
                break;
            }
            int temp = nums / 7;//temp = 3 temp = 0
            nums = nums % 7;    //nums = 2 nums = 3
            //System.out.println("nums:" + nums);
            result.append(nums);
           // System.out.println("result:" + result);
            getMod(temp);
        }
        return result.toString();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到接邻结点的下标w
    public int getNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {//先遍历结点数组
            if (edges[j][index] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    //返回结点个数
    public int getVerNum() {
        return vertexList.size();
    }

    //返回边的条数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点对应的下标0/A,1/B,2/C
    public String getValByIndex(int i) {
        return vertexList.get(i);
    }

    //返回V1,V2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String ver) {
        vertexList.add(ver);
    }
    //显示图对应的矩阵

    public void showGraph() {
        for (int[] item : edges) {
            System.out.println(Arrays.toString(item));
        }
    }


    //插入边
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;

    }

}
