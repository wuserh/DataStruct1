package com.wh.Stack;

public class CalculatorDemo {
    public static void main(String[] args) {

        String expression = "35+2*6-2";
        //创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;//接收操作符
        int res = 0;//运算结果
        char ch = ' ';//将每次扫描到的char保存到ch中

        String keepNum = "";//定义一个字符串变量，用于拼接
        //开始循环扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {//判断当前字符是否为运算符
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peck()))//如果当前的操作符的优先级小于或者等于栈顶操作符
                    {
                        //如何上面的条件满足：则从符号栈中取出一个符号，从数栈中取出两个数进行运算，将得到的结果如数栈，并将当前的操作符如符号栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //吧运算的结果入数栈
                        numStack.push(res);
                        operStack.push(ch);
                    } else {//如果当前的操作符的优先级大于栈顶操作符
                        operStack.push(ch);
                    }
                } else {//如果当前符号栈为空，直接入栈
                    operStack.push(ch);
                }
            } else {//数栈，是数的话，直接入数栈
                //numStack.push(ch - 48);//这里得到的是字符‘1’，而不是数字 1
                //1.当处理一个数时候，不能发现一个数就入数栈，比如多位数
                //2.处理数的时候，需要想expression向后再看一位，如何是数，继续扫描，不是才入栈
                //3.定义一个字符串变量，用于拼接
                keepNum += ch;
                //如果ch已经是expression已经是最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个是不是数字
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }

            }
            index++;//让index+1,并判断是否扫描到expression最后
            if (expression.length() == index) {
                break;
            }

        }


        //扫描完毕后，就顺序从数栈和符号栈中取出响应的数和符号进行运算，结果就是表达式的结果
        while (true) {
            if (operStack.isEmpty())//如果符号栈为空，则数栈中只有一个数字就是结果
            {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //吧运算的结果入数栈
            numStack.push(res);
        }
        System.out.println("表达式的结果为：" + numStack.pop());
    }
}


class ArrayStack2 {

    private int maxSize;//栈的大小
    private int[] stack;//数组，存放栈的数据

    int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//初始化栈
    }

    //得到栈顶的值，但是不是正真的pop
    public int peck() {
        return stack[top];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空，无法遍历");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("数据：" + stack[i]);
        }

    }

    //返回运算级的优先级，自定义，用数字表示，数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {

            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序，用后一个数减去前一个数。
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}