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

        HeroNode root = new HeroNode("1", "zd");
        HeroNode hd1 = new HeroNode("2", "dd");
        HeroNode hd2 = new HeroNode("3", "xx");
        HeroNode hd3 = new HeroNode("4", "ff");
        HeroNode hd4 = new HeroNode("5", "gg");
        HeroNode hd5 = new HeroNode("4", "mm");

        /**
         *       root                 1
         *    hd1    hd2         2       3
         *  hd3    hd4  hd5   4        5    6
         */
        root.setLeft(hd1);
        root.setRight(hd2);
        hd1.setLeft(hd3);
        hd2.setLeft(hd4);
        hd2.setRight(hd5);
        binaryTree.setHeroNode(root);

        // 测试遍历
//        binaryTree.per();124356
//        binaryTree.cent(); 421536
        // 425631
//        binaryTree.post();
        // 测试查找
//        HeroNode heroNode = binaryTree.perSearch("3");
//        System.out.println(heroNode);
        // 测试删除
        binaryTree.del("4");
        binaryTree.per();

    }
}

class BinaryTree {
    private HeroNode heroNode;

    public void setHeroNode(HeroNode heroNode) {
        this.heroNode = heroNode;
    }

    public void del(String id) {
        if (heroNode != null) {
            if (heroNode.getId().equals(id)) {
                heroNode = null;
            } else {
                heroNode.delNode(id);
            }
        }
    }

    public HeroNode perSearch(String id) {
        return heroNode.perSearch(id);
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

/**
 * 树节点
 * id name 节点数据
 * left、right  指针，分别指向左节点和右节点
 */
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
     * 删除节点
     * @param id
     */
    public void delNode(String id) {
        if (this.left != null) {
            if (this.left.id.equals(id)) {
                this.left = null;
                return;
            } else {
                this.left.delNode(id);
            }
        }
        //TODO 节点在左子树删了，就不要遍历右子树了。return true 或者 false
        if (this.right != null) {
            if (this.right.id.equals(id)) {
                this.right = null;
            } else {
                this.right.delNode(id);
            }
        }
    }
    /**
     * 前序遍历搜索
     * @param id
     * @return
     */
    public HeroNode perSearch(String id) {
        if (this.id.equals(id)) {
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.perSearch(id);
            if (heroNode != null) {
                return heroNode;
            }
        }
        if (this.right != null) {
            heroNode = this.right.perSearch(id);
        }
        return heroNode;
    }

    /**
     * 中序遍历搜索
     * @param id
     * @return
     */
    public HeroNode indexSearch(String id) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode= this.left.indexSearch(id);
            if (heroNode != null) {
                return heroNode;
            }
        }
        if (this.id.equals(id)) {
            return this;
        }
        if (this.right != null) {
            heroNode = this.right.indexSearch(id);
        }
        return heroNode;
    }

    /**
     * 后序遍历搜索
     * @param id
     * @return
     */
    public HeroNode postSearch(String id) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.postSearch(id);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.postSearch(id);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.id.equals(id)) {
            return this;
        }
        return null;
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
