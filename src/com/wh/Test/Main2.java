package com.wh.Test;


interface interface1 {
    void fun1();

    void fun2();

    void fun3();

    void fun4();

    void fun5();
}

class A implements interface1 {


    @Override
    public void fun1() {
        System.out.println("类A方法1");
    }

    @Override
    public void fun2() {
        System.out.println("类A方法2");
    }

    @Override
    public void fun3() {
        System.out.println("类A方法3");
    }

    @Override
    public void fun4() {
        System.out.println("类A方法4");
    }

    @Override
    public void fun5() {
        System.out.println("类A方法5");
    }
}

class B implements interface1 {

    @Override
    public void fun1() {
        System.out.println("类B方法1");
    }

    @Override
    public void fun2() {
        System.out.println("类B方法2");
    }

    @Override
    public void fun3() {
        System.out.println("类B方法3");
    }

    @Override
    public void fun4() {
        System.out.println("类B方法4");
    }

    @Override
    public void fun5() {
        System.out.println("类B方法5");
    }
}

class C {
    public void dependece1(interface1 interface1) {
        interface1.fun1();
    }

    public void dependece2(interface1 interface1) {
        interface1.fun2();
    }

    public void dependece3(interface1 interface1) {
        interface1.fun3();
    }
}


public class Main2 {
    //测试volatile的可见性
    public static void main(String[] args) {
        C a = new C();
        a.dependece1(new A());
//        int[] arrs = {4 ,3, 2, 1};//2,1,0,0,length = 3
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        int[] out = new int[arrs.length];
//        int num = 0;
//        for (int i = 0; i < arrs.length - 1; i++) {
//            for (int j = i + 1; j < arrs.length; j++) {
//                if (arrs[i] < arrs[j]) {
//                    out[i] = j - i;
//                    //System.out.println(j - i);
//                    break;
//                }
//            }
//        }
//        for (int item : out) {
//            System.out.println(item);
//        }

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String inPutString = sc.nextLine();
//            String[] word = inPutString.split("");
//            int[][] maxLength = new int[word.length + 1][word.length + 1];
//            for (int i = 0; i < word.length; i++) {
//                for (int j = 0; j < word.length; j++) {
//                    if (word[i].equals(word[word.length - 1 - j])) {//正序的每一个字符同反序的每一个字符比较
//                        maxLength[i + 1][j + 1] = maxLength[i][j] + 1;
//                    } else {//对应的字符不相同  则取前面相同字符数中最大那个
//                        maxLength[i + 1][j + 1] = Math.max(maxLength[i + 1][j], maxLength[i][j + 1]);
//                    }
//                }//这样得到就是相同字符数最多的值  就是回文的长度  总长减去此长  就得到要删减的数目
//            }
//            System.out.println(word.length - maxLength[word.length][word.length]);
//        }
    }

}
