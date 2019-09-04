package com.wh.kmp;

public class KMPAlg {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int index = kmpSearch(str1, str2, kmpNext(str2));
        System.out.println("index = " + index);
    }


    //KMP算法

    /**
     * @param str1 原字符串
     * @param str2 子串
     * @param next 子串的部分匹配表
     * @return -1表示没有匹配到，否则返回第一个匹配到的index
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历str1
        for (int i = 0, j = 0; i < str1.length(); i++) {


            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];//核心
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {//找到了
                return i - j + 1;
            }
        }
        return -1;
    }


    //获取部分匹配表
    public static int[] kmpNext(String str) {
        int[] next = new int[str.length()];//保存部分匹配值
        next[0] = 0;//如果长度字符为1，部分匹配值就是0
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];//核心
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
