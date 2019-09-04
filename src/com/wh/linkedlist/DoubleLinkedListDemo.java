package com.wh.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        System.out.println("***双向链表测试***");

        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "11", "111");
        HeroNode2 hero2 = new HeroNode2(3, "22", "222");
        HeroNode2 hero3 = new HeroNode2(5, "33", "333");
        HeroNode2 hero4 = new HeroNode2(7, "44", "444");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        HeroNode2 newHero2 = new HeroNode2(1, "22", "22");

        doubleLinkedList.update(newHero2);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {

        // System.out.println("测试："+head.next);
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //因为头节点不能动，所有需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

    //添加一个节点到双向链表最后
    //思路:1.找到当前链表的最后节点
    //2.将最后节点的next指向新的节点
    public void add(HeroNode2 heroNode) {

        HeroNode2 temp = head;//头节点开始，一直遍历到最后，再将新加的节点放到后面即可
        while (temp.next != null) {

            //当temp的下一个节点为空的时候，表示找到了最后一个
            //如果没找到，遍历
            temp = temp.next;
            //System.out.println("次数" + temp);
        }
        //当退出while循环的时候表示temp就指向了链表的最后，并将最后这个节点指向新添加的节点
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //和单向一样
    //修改节点的信息，编号num不能改
    //根据新的节点的num来下修改
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法修改");
            return;
        }
        //找到需要修改的节点
        //定义一个辅助变量
        HeroNode2 temp = head.next;//这里好像直接为head也可以，但是后面的条件修改
        boolean flag = false;//是否找到的标志位
        while (temp != null) {
            if (temp.num == newHeroNode.num) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//找到了
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没有找到编号为" + newHeroNode.num + "的节点");
        }
    }


    //双向链表，可直接找到要删除的这个节点，不需要找到要删除节点的前一个节点，找到后自我删除
    public void delet(int num) {
        if (head.next == null) {
            System.out.println("双链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        //boolean flag = false;

        //找到了待删除节点的前一个节点
        //  flag = true;
        while (temp.num != num) {
            temp = temp.next;//遍历
        }
        temp.pre.next = temp.next;
        //如果是删除最后一个节点，下面这个不需要执行，否则空指针异常
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
    }


}


//定义一个HeroNode,每一个HeroNode 对象就是一个节点
class HeroNode2 {
    public int num;
    public String name;
    public String nickName;

    public HeroNode2 pre;//指向前一个节点
    public HeroNode2 next;//指向下一个节点

    public HeroNode2(int num, String name, String nickName) {
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