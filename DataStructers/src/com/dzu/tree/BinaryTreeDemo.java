package com.dzu.tree;

/**
 * @author by ZhaoDong
 * @Classname BinaryTree
 * @Description 二叉树
 * @Date 2022/2/16 21:45
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode("1","zd");
        HeroNode hd1 = new HeroNode("2","dd");
        HeroNode hd2 = new HeroNode("3","xx");
        HeroNode hd3 = new HeroNode("4","ff");
        HeroNode hd4 = new HeroNode("5","gg");
        HeroNode hd5 = new HeroNode("6","mm");

        /**
         *       root
         *    hd1    hd2
         *  hd3    hd4  hd5
         */
        root.setLeft(hd1);
        root.setRight(hd2);
        hd1.setLeft(hd3);
        hd2.setLeft(hd4);
        hd2.setRight(hd5);
        binaryTree.setHeroNode(root);

//        binaryTree.per();124356
//        binaryTree.cent(); 421536
        // 425631
        binaryTree.post();

    }
}

class BinaryTree {
    private HeroNode heroNode;

    public void setHeroNode(HeroNode heroNode) {
        this.heroNode = heroNode;
    }

    public void per() {
        if (heroNode != null) {
            heroNode.perOrder();
        }
    }
    public void cent() {
        if (heroNode != null) {
            heroNode.centOrder();
        }
    }

    public void post() {
        if (heroNode != null) {
            heroNode.postOrder();
        }
    }
}


class HeroNode {

    private String id;
    private String name;

    private HeroNode left;
    private HeroNode right;


    public HeroNode(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * 前序遍历
     */
    public void perOrder() {

        // 父节点
        System.out.println(this);


        // 左节点
        if (this.left != null) {
            this.left.perOrder();
        }

        // 右节点
        if (this.right != null) {
            this.right.perOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void centOrder() {
        // 左节点
        if (this.left != null) {
            this.left.centOrder();
        }

        // 父节点
        System.out.println(this);

        // 右节点
        if (this.right != null) {
            this.right.centOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        // 左节点
        if (this.left != null) {
            this.left.postOrder();
        }
        // 右节点
        if (this.right != null) {
            this.right.postOrder();
        }
        // 父节点
        System.out.println(this);
    }







    @Override
    public String toString() {
        return "HeroNode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", }";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
