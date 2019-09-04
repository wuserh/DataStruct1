package com.wh.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {


        //定义一个逆波兰表达式

        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> test = getListString(suffixExpression);
        System.out.println("test" + test);
        System.out.println("结果为：" + getRes(test));

        //中缀表达式转后缀表达式
        //输入 a+b*c/d-a+f/b 输出 abc*d/+a-fb/+

        String expression = "a + b * c / d - a + f / b";


    }

    public static List<String> getListString(String suffixExpression) {
        String[] strings = suffixExpression.split(" ");

        List<String> list = new ArrayList<>();

        for (String s : strings) {
            list.add(s);
        }
        return list;
    }

//    public static List<String> getResult(List<String> list) {
//
//        Stack<String> stack = new Stack<>();
//
//        for (int i=0;i<list.size();i++){
//
//            if (list.get(i).matches("\\d+")){
//                stack.push(list.get(i));
//
//            }
//
//        }
//
//
//    }

    //优先级判断
    public static int prioprty(String s) {

        if (s.equals("(") || s.equals(")")) {
            return 3;
        }

        if (s.equals("*") || s.equals("/")) {
            return 2;
        }

        if (s.equals("+") || s.equals("-")) {
            return 1;
        }

        return 0;
    }


    public static int getRes(List<String> list) {

        Stack<String> stack = new Stack<>();

        for (String s : list) {
            if (s.matches("\\d+")) {//如果是数字
                stack.push(s);
            } else {
                int num1, num2, num = 0;
                num1 = Integer.valueOf(stack.pop());
                num2 = Integer.valueOf(stack.pop());

                if (s.equals("*")) {
                    num = num1 * num2;
                } else if (s.equals("+")) {
                    num = num1 + num2;
                } else if (s.equals("/")) {
                    num = num2 / num1;
                } else if (s.equals("-")) {
                    num = num2 - num1;
                } else {
                    System.out.println("符号异常");
                }
                stack.push(num + "");
            }

        }
        return Integer.valueOf(stack.pop());
    }

}


