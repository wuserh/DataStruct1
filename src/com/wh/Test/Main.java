package com.wh.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //compareVersion("1.01", "1");
        System.out.println(compareVersion("1.0", "1.00"));

//        String ss[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String s1[] = {"eat", "tea"};
//        String s2[] = {""};
//        System.out.println(groupAnagrams(ss));


//        String te = "the sky is blue";
//        reverseWords(te);
    }


    //版本大小比较20190903
    public static int compareVersion(String s1, String s2) {

        String[] temp1 = s1.split("\\.");
        String[] temp2 = s2.split("\\.");

        for (int n = 0; n < Math.max(temp1.length, temp2.length); n++) {
            int i = (n < temp1.length ? Integer.valueOf(temp1[n]) : 0);
            int j = (n < temp2.length ? Integer.valueOf(temp2[n]) : 0);
            if (i < j) return -1;
            else if (i > j) return 1;
        }
        return 0;
    }


    //单词反转20190903
    //the sky is blue
    //先反转每个单词，再整体反转
    //eht yks si eulb
    //blue is sky the
//    public static String reverseWords(String s) {
//
//        List<String> list = new ArrayList<>();
//        System.out.println(Arrays.toString(s.trim().split("\\s+")));
//
//        for (String str : s.trim().split("\\s+")) {
//
//            list.add(0, str);
//            System.out.println(list);
//        }
//        return String.join(" ", list);
//    }


    //分类20190903
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();

        for (String item : strs) {
            char[] chars = item.toCharArray();//将字符串数组的每一个元素转化为字符型数组
            Arrays.sort(chars);//排序
            String key = String.valueOf(chars);//将每一个字符再转化为字符串，并且作为key值

            if (hash.containsKey(key)) {//如果hash有这个key
                hash.get(key).add(item);
            } else {//如果没有这个key，就把这个key和这个值放到hash中(第一次出现的)
                List<String> temp = new ArrayList<>();
                temp.add(item);
                hash.put(key, temp);
            }
        }
        return new ArrayList<>(hash.values());
    }


//        Scanner sc = new Scanner(System.in);
//        String[] left, right;
//        String[] line;
//        String nextLine, outString;
//        while (sc.hasNext()) {
//            nextLine = sc.nextLine();
//            //有王炸就王炸最大
//            if (nextLine.contains("joker JOKER")) {
//                outString = "joker JOKER";
//            } else {
//                //拆分 先拆成左右 再拆成单排
//                line = nextLine.split("-");
//                left = line[0].split(" ");
//                right = line[1].split(" ");
//
//                //炸弹最大
//                if (left.length == 4 && right.length != 4) {
//                    outString = line[0];
//                } else if (right.length == 4 && left.length != 4) {
//                    outString = line[1];
//                }
//                // 牌数相同的情况下比较最小的牌的大小，通过ENUM方法返回牌所对应的值
//                else if (right.length == left.length) {
//                    if (count(left[0]) > count(right[0])) {
//                        outString = line[0];
//                    } else {
//                        outString = line[1];
//                    }
//                } else {
//                    outString = "ERROR";
//                }
//            }
//
//            System.out.println(outString);
//
//        }
//
//
//    }
//
//    enum PaperLevel {
//        ZERO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K, A, DOUBLE, joker, JOKER,
//    }
//
//    public static int count(String str) {
//        int paperLevel;
//        switch (str) {
//            case "3":
//                paperLevel = PaperLevel.THREE.ordinal();
//                break;
//            case "4":
//                paperLevel = PaperLevel.FOUR.ordinal();
//                break;
//            case "5":
//                paperLevel = PaperLevel.FIVE.ordinal();
//                break;
//            case "6":
//                paperLevel = PaperLevel.SIX.ordinal();
//                break;
//            case "7":
//                paperLevel = PaperLevel.SEVEN.ordinal();
//                break;
//            case "8":
//                paperLevel = PaperLevel.EIGHT.ordinal();
//                break;
//            case "9":
//                paperLevel = PaperLevel.NINE.ordinal();
//                break;
//            case "10":
//                paperLevel = PaperLevel.TEN.ordinal();
//                break;
//            case "J":
//                paperLevel = PaperLevel.J.ordinal();
//                break;
//            case "Q":
//                paperLevel = PaperLevel.Q.ordinal();
//                break;
//            case "K":
//                paperLevel = PaperLevel.K.ordinal();
//                break;
//            case "A":
//                paperLevel = PaperLevel.A.ordinal();
//                break;
//            case "2":
//                paperLevel = PaperLevel.DOUBLE.ordinal();
//                break;
//            case "joker":
//                paperLevel = PaperLevel.joker.ordinal();
//                break;
//            case "JOKER":
//                paperLevel = PaperLevel.JOKER.ordinal();
//                break;
//            default:
//                paperLevel = PaperLevel.ZERO.ordinal();
//                break;
//        }
//        return paperLevel;
}
