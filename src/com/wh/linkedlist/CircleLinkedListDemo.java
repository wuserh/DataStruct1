package com.wh.linkedlist;

public class CircleLinkedListDemo {

    //思路：1先创建一个节点，让First指向该节点，并形成环状，
    // 2.每创建一个新的节点，就把该节点加入到已知的环形链表中

    //遍历:1.先让一个辅助指针curBoy指向first节点，
    //2、然后通过一个while循环遍历，当curBoy.next == first结束

    public static void main(String[] args) {
//        Boy boy1 = new Boy(1);
//        Boy boy2 = new Boy(2);
//        Boy boy3 = new Boy(3);
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addBoy(5);//加入5个小孩
        //circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1, 2, 5);
    }

}

class CircleSingleLinkedList {

    //创建第一个first节点，当前没有编号
    private Boy first = new Boy(0);

    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("num不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        for (int i = 1; i <= num; i++) {
            //System.out.println("次数：" + i);
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);//新节点的环首
                boy.setNext(first);//新节点的环尾
                curBoy = boy;//辅助指针后移
            }

        }
    }

    //遍历当前环形链表

    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空~！");
            return;
        }
        //因为first不能动，所以构建辅助指针，完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号为：" + curBoy.getNum());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    //根据用户输入，计算出圈顺序
    /*
    1.创建辅助指针helper，指向环形链表的最后一个节点
    2.当小孩报数之前，将first和helper移动到k-1处
    3.first和helper同时后移m-1次
    4.小孩出圈，helper.next = first
               first.next = first
     */

    /**
     * @param startBoyNum, 表示从第几个小孩开始数k
     * @param countBoyNum  数几下m
     * @param sumBoyNum    共有多少小孩在圈中n
     */
    public void countBoy(int startBoyNum, int countBoyNum, int sumBoyNum) {
        if (first == null || startBoyNum < 1 || startBoyNum > sumBoyNum) {
            System.out.println("参数输入有误！");
            return;
        }
        Boy boyHelper = first;
        while (true) {
            if (boyHelper.getNext() == first) {//说明boyHelper指向了最后一个节点
                break;
            }
            boyHelper = boyHelper.getNext();
        }
        for (int i = 0; i < startBoyNum - 1; i++) {
            first = first.getNext();
            boyHelper = boyHelper.getNext();
        }
        while (true) {
            if (boyHelper == first) {
                break;
            }
            for (int i = 0; i < countBoyNum - 1; i++) {
                first = first.getNext();
                boyHelper = boyHelper.getNext();
            }
            System.out.println("小孩 " + first.getNum() + " 出圈");
            first = first.getNext();
            boyHelper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩为：" + first.getNum());

    }


}

//小孩类，表示一个节点
class Boy {
    private int num;
    private Boy next;

    public Boy(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}