package com.wh.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建结点
        HeroNode heroNode1 = new HeroNode(1, "111");
        HeroNode heroNode2 = new HeroNode(2, "222");
        HeroNode heroNode3 = new HeroNode(3, "333");
        HeroNode heroNode4 = new HeroNode(4, "444");
        HeroNode heroNode5 = new HeroNode(5, "555");
        HeroNode heroNode6 = new HeroNode(6, "666");
        HeroNode heroNode7 = new HeroNode(7, "777");
        binaryTree.setRoot(heroNode1);
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        heroNode2.setLeft(heroNode6);
        heroNode2.setRight(heroNode7);
        System.out.println("前序遍历1,2,6,7,3,5,4");
        binaryTree.preOrder();
        System.out.println("中序遍历6,2,7,1,5,3,4");
        binaryTree.midOrder();
        System.out.println("后序遍历6,7,2,5,4,3,1");
        binaryTree.postOrder();

//        HeroNode resNode = binaryTree.postSearchTest(5);
//        System.out.println("找到" + resNode.getName());
//        System.out.println("删除前：");
//        binaryTree.preOrder();
//        System.out.println("删除后：");
//        binaryTree.deletNode(3);
//        binaryTree.preOrder();

    }

    static class BinaryTree {

        private HeroNode root;

        public void setRoot(HeroNode root) {
            this.root = root;
        }

        public void deletNode(int no) {
            if (root != null) {
                if (root.getNum() == no) {
                    root = null;
                } else {
                    root.deletNode(no);
                }
            } else {
                System.out.println("空树，无法删除");
            }
        }

        //前序
        public void preOrder() {
            if (this.root != null) {
                this.root.preOrder();
            } else {
                System.out.println("为空！！");
            }
        }

        public void midOrder() {
            if (this.root != null) {
                this.root.midOrder();
            } else {
                System.out.println("为空！！");
            }
        }

        public void postOrder() {
            if (this.root != null) {
                this.root.postOrder();
            } else {
                System.out.println("为空！！");
            }
        }


        public HeroNode preSearchTest(int no) {
            if (root != null) {
                return root.preOrderSearch(no);
            } else {
                return null;
            }
        }


        public HeroNode midSearchTest(int no) {
            if (root != null) {
                return root.midOrderSearch(no);
            } else {
                return null;
            }
        }


        public HeroNode postSearchTest(int no) {
            if (root != null) {
                return root.postOrderSearch(no);
            } else {
                return null;
            }
        }


    }


    static class HeroNode {
        private int num;
        private String name;
        private HeroNode left;
        private HeroNode right;

        public HeroNode(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getLeft() {
            return left;
        }

        public void setLeft(HeroNode left) {
            this.left = left;
        }

        public HeroNode getRight() {
            return right;
        }

        public void setRight(HeroNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "num=" + num +
                    ", name='" + name + '\'' +
                    '}';
        }


        //递归删除结点
        public void deletNode(int no) {

            if (this.left != null && this.left.num == no) {//如果当前结点的左子结点不为空，并且就是要删除的结点,则直接置空，并返回（结束删除递归）
                this.left = null;
                return;

            }

            if (this.right != null && this.right.num == no) {//如果当前结点的右子结点不为空，并且就是要删除的结点,则直接置空，并返回（结束删除递归）

                if (this.right.left == null && this.right.right == null) {//要删除的节点的左右都为空
                    this.right = null;
                    return;
                }
                if (this.right.left != null && this.right.right == null) {//要删除的节点的左边不为空，右边为空。就把左边的节点升级为当前节点的右节点
                    this.setRight(this.right.left);
                }
                if (this.right.left == null && this.right.right != null) {//要删除的节点的左边为空，右边不为空。就把右边的节点升级为当前节点的右节点
                    this.setRight(this.right.right);
                }
                if (this.right.left != null && this.right.right != null) {//要删除的节点的都不为空。就把左边的节点升级为当前节点的右节点，右边节点设为升级节点的右节点
                    HeroNode temp = null;//先保存住右节点
                    temp = this.right.right;
                    this.setRight(this.right.left);
                    this.right.setRight(temp);
                }

            }
            //如果上面都没有满足，则向左子树递归删除
            if (this.left != null) {
                this.left.deletNode(no);
            }
            //如果上面都没有满足，则向右子树递归删除
            if (this.right != null) {
                this.right.deletNode(no);
            }
        }


        //前序遍历方法
        public void preOrder() {
            System.out.println(this);//输出父结点
            if (this.left != null) {//递归向遍历左子树前序遍历
                this.left.preOrder();
            }
            if (this.right != null) {
                this.getRight().preOrder();
            }
        }

        //中序遍历
        public void midOrder() {
            //递归向左子树中序遍历
            if (this.left != null) {
                this.left.midOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.midOrder();
            }
        }

        //后序遍历
        public void postOrder() {
            //递归向右子树中序遍历
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }

        //前序遍历查找
        public HeroNode preOrderSearch(int curNum) {
            if (this.num == curNum) {//先看当前结点是否是的，是的则返回
                return this;
            }
            HeroNode temp = null;
            if (this.left != null) { //判断当前结点的左节点是否为空，如果不为空，则进行左递归前序遍历
                temp = this.left.preOrderSearch(curNum);
            }
            if (temp != null) {    //说明在左递归的时候找到了
                return temp;
            }
            if (this.right != null) {//判断当前结点的右节点是否为空，如果不为空，则进行右递归前序遍历
                temp = this.right.preOrderSearch(curNum);
            }
            return temp;
        }


        //中序遍历查找
        public HeroNode midOrderSearch(int curNum) {
            HeroNode temp = null;
            if (this.left != null) {//判断当前结点的左子节点是否为空，不为空，则进行递归中序遍历
                temp = this.left.midOrderSearch(curNum);
            }
            if (temp != null) {
                return temp;//如果找到，则返回，
            }
            //如果没有照的，则和当前结点比较
            if (this.num == curNum) {
                return this;//找到则返回
            }
            //如果没有找到，则向右递归中序查找
            if (this.right != null) {
                temp = this.right.midOrderSearch(curNum);
            }
            return temp;
        }

        //后序遍历查找
        public HeroNode postOrderSearch(int curNum) {
            HeroNode temp = null;
            if (this.left != null) {//判断当前结点的左子节点是否为空，不为空，则进行递归后序遍历
                temp = this.left.postOrderSearch(curNum);
            }
            if (temp != null) {
                return temp;//如果找到，则返回，
            }
            //如果左子树没有找到，则向右递归中序查找
            if (this.right != null) {
                temp = this.right.postOrderSearch(curNum);
            }
            if (temp != null) {
                return temp;//如果找到，则返回，
            }
            System.out.println("后续查找————");
            //如果没有照的，则和当前结点比较
            if (this.num == curNum) {
                return this;//找到则返回
            }
            return null;
        }


    }
}
