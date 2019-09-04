package com.wh.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node maxNode = creatHuffmanTree(arr);
        preOrder(maxNode);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preSearch();
        } else {
            System.out.println("为空！无法遍历");
        }
    }


    //创建哈夫曼树
    public static Node creatHuffmanTree(int[] arr) {
        //为了方便，先遍历arr
        //将每个arr[i]构成一个Node
        //放入ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int item : arr) {
            nodes.add(new Node(item));
        }

        /**
         * 下面处理的过程是循环过程
         *
         */

        while (nodes.size() > 1) {
            //1.排序从小到大（this.val - o.val）
            Collections.sort(nodes);
            //System.out.println("未处理的:" + nodes);

            //2.取出根结点权值最小的两颗二叉树.就是排序后的节点的前两个
            Node leftNode = nodes.get(0);//最小的
            Node rightNode = nodes.get(1);//倒数第二小的
            Node parents = new Node(leftNode.val + rightNode.val);//构建一个新的二叉树
            parents.left = leftNode;//将二叉树挂起来
            parents.right = rightNode;
            //3从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //4.将新的二叉树加入到ArrayList
            nodes.add(parents);
            Collections.sort(nodes);
            //System.out.println( nodes);
        }
        return nodes.get(0);
    }
}

//创建一个结点类
//为了让Node进行排序，实现comparable接口
class Node implements Comparable<Node> {
    int val;//节点权值
    Node left;//左子结点
    Node right;//右子结点


    public void preSearch() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preSearch();
        }
        if (this.right != null) {
            this.right.preSearch();
        }
    }

    public Node(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;//表示从小到大排序
    }
}
