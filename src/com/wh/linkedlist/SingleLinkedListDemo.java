package com.wh.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //先创建节点
        HeroNode hero1 = new HeroNode(1, "11", "111");
        HeroNode hero2 = new HeroNode(3, "22", "222");
        HeroNode hero3 = new HeroNode(5, "33", "333");
        HeroNode hero4 = new HeroNode(7, "44", "444");


        //先创建节点
        HeroNode hero5 = new HeroNode(2, "11", "111");
        HeroNode hero6 = new HeroNode(4, "22", "222");
        HeroNode hero7 = new HeroNode(6, "33", "333");
        HeroNode hero8 = new HeroNode(8, "44", "444");

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);
        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero2);
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero4);

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByOrder(hero5);
        singleLinkedList2.addByOrder(hero6);
        singleLinkedList2.addByOrder(hero7);
        singleLinkedList2.addByOrder(hero8);
//        HeroNode heroNode = new HeroNode(1, "22", "33");
//        singleLinkedList.update(heroNode);
//        singleLinkedList.delet(1);
//        singleLinkedList.delet(4);
        //singleLinkedList1.list();
        //combine(singleLinkedList1.getHead(), singleLinkedList2.getHead());

        //System.out.println(getLinkedListLength(singleLinkedList.getHead()));
        //reverse(singleLinkedList.getHead());
        //reversePrintf(singleLinkedList.getHead());
        //singleLinkedList.list();
        //System.out.println(findLastIndexNode(singleLinkedList.getHead(), 5));
    }

    //获取单链表的节点个数，带头节点的需去掉
    public static int getLinkedListLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;//没有统计头节点，直接指向head.next
        while (cur != null) {
            length++;
            cur = cur.next;//遍历
        }
        return length;
    }

    //查找单链表的倒数第K个节点
    //1.接收head和index
    //2.index为倒数第index个节点
    //3.先遍历链表，得到链表的总长度size
    //4.再从开始遍历到size-index，就得到倒数第K个
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        //第一次遍历先求链表的总长度
        int size = getLinkedListLength(head);
        //第二次遍历size-index位置，就是要找的倒数第K个节点。
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //将链表反转
    //思路：1先定义一个节点，reverseHead = new HeroNode()
    //2.从头遍历到尾，每遍历一个节点，就将其取出放到新的链表reverseHead的前面首位置
    //3.原来链表的head.next = reverse.next
    public static void reverse(HeroNode head) {
        //为空和只有一个节点的情况,无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode(0, "", "");//定义一个新的节点
        HeroNode cur = head.next;//定义一个辅助指针，帮助遍历原来的链表
        HeroNode curNext = null;//指向当前节点的下一个节点

        while (cur != null) {//遍历原来的链表，每遍历一个节点，将其取出，并放在新的链表reverseHead的最前端

            curNext = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端,这样考虑，将左右两边的.next约去更好理解
            reverseHead.next = cur;//将新链表的头节点的next指向当前链表的最前端
            cur = curNext;//后移cur
        }
        head.next = reverseHead.next;
    }


    //将链表反向打印，利用栈
    public static void reversePrintf(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈，将链表的各个节点压入栈中
        Stack<HeroNode> heroNodeStack = new Stack<>();
        //定义一个辅助变量，遍历链表
        HeroNode temp = head;
        while (temp.next != null) {
            heroNodeStack.push(temp.next);
            temp = temp.next;

        }
        //将栈中的节点进行打印，pop出栈
        while (heroNodeStack.size() > 0) {
            System.out.println(heroNodeStack.pop());
        }
    }

//    //合并两个有序的单链表，合并之后仍然有序
//    public static HeroNode combine(HeroNode head1, HeroNode head2) {
//        if (head1.next == null && head2 == null) {
//            return null;
//        }
//        if (head1.next == null) {
//            return head2;
//        }
//        if (head2.next == null) {
//            return head1;
//        }
//
//        if (head1.num < head2.num) {
//            head1.next = combine(head1.next, head2);
//        }
//
////        //定义合并后的链表
////        HeroNode combineHead = new HeroNode(0, "", "");
////        //HeroNode cur = combineHead;
////        //定义两个辅助节点遍历需要合并的链表
//////        HeroNode temp1 = head1.next;
//////        HeroNode temp2 = head2.next;
////
////        while (head1.next != null && head2.next != null) {
////
////            if (head1.next.num < head2.next.num) {
////                combineHead.next = head1;
////                combineHead = combineHead.next;
////                head1 = head1.next;
////            } else {
////                combineHead.next = head2;
////                combineHead = combineHead.next;
////                head2 = head2.next;
////            }
////        }
////        System.out.println("合并后的链表：" + combineHead.next);
////        return combineHead.next;
//
//
//    }

}

//定义SingleLinkedList管理
class SingleLinkedList {

    //定义头节点，不动,不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路:1.找到当前链表的最后节点
    //2.将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {

        HeroNode temp = head;//头节点开始，一直遍历到最后，再将新加的节点放到后面即可
        while (temp.next != null) {

            //当temp的下一个节点为空的时候，表示找到了最后一个
            //如果没找到，遍历
            temp = temp.next;
            //System.out.println("次数" + temp);
        }
        //当退出while循环的时候表示temp就指向了链表的最后，并将最后这个节点指向新添加的节点
        temp.next = heroNode;
    }

    //第二种添加的方法，按照顺序,画图理解很好！！！！！
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;//头节点不能动，所以用辅助变量，单链表，我们所需要找得temp是位于添加位置的前一个节点，不然添加失败
        boolean flag = false;

        while (true) {

            if (temp.next == null) {
                //遍历到了链表最后
                break;
            }
            if (temp.next.num > heroNode.num) {//位置找到，就这temp后面
                break;
            } else if (temp.next.num == heroNode.num) {//添加的元素已存在
                flag = true;
                break;
            }
            temp = temp.next;//遍历
        }
        if (flag) {
            System.out.println("编号已存在，不能添加");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;

        }
    }

    //修改节点的信息，编号num不能改
    //根据新的节点的num来下修改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法修改");
            return;
        }
        //找到需要修改的节点
        //定义一个辅助变量
        HeroNode temp = head.next;//这里好像直接为head也可以，但是后面的条件修改
        boolean falg = false;//是否找到的标志位
        while (temp != null) {

            if (temp.num == newHeroNode.num) {
                //找到了
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if (falg) {//找到了
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没有找到编号为" + newHeroNode.num + "的节点");
        }
    }

    //删除节点，head不能动，定义一个辅助节点temp,temp为待删除节点前一个节点
    public void delet(int num) {
        HeroNode temp = head;
        //boolean flag = false;

        while (true) {
            if (temp.next == null) {//遍历到了链表最后
                return;
            }
            if (temp.next.num == num) {//找到了待删除节点的前一个节点
                //  flag = true;
                break;
            }
            temp = temp.next;//遍历
        }
        temp.next = temp.next.next;
    }

    //显示链表
    public void list() {

        // System.out.println("测试："+head.next);
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //因为头节点不能动，所有需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后,是否多余？
            if (temp == null) {
                break;
            }
            //输出节点信息
            //System.out.println("测试输出");
            System.out.println(temp);
            //将temp后移，不然是死循环
            temp = temp.next;
        }

    }

}


//定义一个HeroNode,每一个HeroNode 对象就是一个节点
class HeroNode {
    public int num;
    public String name;
    public String nickName;

    public HeroNode next;//很重要，指向下一个节点

    public HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}