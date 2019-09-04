package com.wh.huffmantree;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();//存放每一个字符的ascii码值
//        for (byte item : contentBytes) {
//            System.out.println(item);
//        }
        System.out.println("未压缩长度：" + contentBytes.length);
        //System.out.println(getNodes(contentBytes));
        //creatHuffmanTree(getNodes(contentBytes));
        Nodes hufuman = creatHuffmanTree(getNodes(contentBytes));

        System.out.println("前序遍历");
        preSerach(hufuman);
        System.out.println("压缩后长度：");

    }


    private static void preSerach(Nodes root) {
        if (root != null) {
            root.preSerach();
        } else {
            System.out.println("error");
        }

    }

    private static Nodes creatHuffmanTree(List<Nodes> nodes) {

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Nodes left = nodes.get(0);
            Nodes right = nodes.get(1);
            Nodes parents = new Nodes(null, left.weight + right.weight);//没有data,只有权值
            //将新的二叉树挂起来
            parents.left = left;
            parents.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parents);
        }
        return nodes.get(0);
    }


    /**
     * @param bytes 接收字节数组
     * @return 返回List形式[Node[data=97,weight=5],Node[data=32,weight=9],.......]
     */
    private static List<Nodes> getNodes(byte[] bytes) {
        ArrayList<Nodes> nodes = new ArrayList<>();

        //需要统计每个字符（ASCII码）出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
//        for (byte item : bytes) {
//            Integer count = counts.get(item);
//            if (count == null) {
//                counts.put(item, 1);
//            } else {
//                counts.put(item, count + 1);
//            }
//        }

        //新方法
        for (byte item : bytes) {
            counts.merge(item, 1, Integer::sum);
        }
        //把每一个键值对转为Nodes对象，并加入nodes集合中
        //遍历Map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Nodes(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
}

class Nodes implements Comparable<Nodes> {
    Byte data;//存放数据，比如'a'-->97
    int weight;//权值，表示某个data出现的次数
    Nodes left;
    Nodes right;

    public Nodes(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    //前序遍历
    public void preSerach() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preSerach();
        }
        if (this.right != null) {
            this.right.preSerach();
        }
    }


    @Override
    public String toString() {
        return "Nodes{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Nodes o) {
        return this.weight - o.weight;//从小到大
    }
}
