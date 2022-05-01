package com.dzu.tree;

/**
 * @author ZhaoDong
 * @date 2022/5/1 19:53
 * @description 128、二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 6, 11, 22, 40, 31, 29, 24, 2, 8};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.indexSearch();
        System.out.println("binarySortTree.searchNode(1) = " + binarySortTree.searchNode(10));
        System.out.println("binarySortTree.searchNode(1) = " + binarySortTree.searchNodeParent(12));
    }
}

class BinarySortTree {
    private Node root;

    public Node searchNode(int id) {
        return root.searchNode(id);
    }

    public Node searchNodeParent(int id) {
        return root.searchNodeParent(id);
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void indexSearch() {
        if (root == null) {
            return;
        }
        root.indexSearch();
    }
}

class Node {
    int id;
    Node left;
    Node right;

    public Node(int id) {
        this.id = id;
    }

    public Node searchNodeParent(int id) {
        if ((this.left != null && this.left.id == id) || (this.right != null && this.right.id == id)) {
            return this;
        } else if (this.left != null && id < this.id) {
            return this.left.searchNodeParent(id);
        } else if (this.right != null && id >= this.id) {
            return this.right.searchNodeParent(id);
        } else {
            return null;
        }
    }

    /**
     * 搜索节点
     *
     * @param id
     * @return
     */
    public Node searchNode(int id) {
        if (this.id == id) {
            return this;
        }
        if (this.left != null && id < this.id) {
            return this.left.searchNode(id);
        }
        if (this.right != null && id >= this.id) {
            return this.right.searchNode(id);
        }
        return null;
    }

    /**
     * 二叉排序树的创建
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.id < this.id) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历二叉树
     */
    public void indexSearch() {
        if (this.left != null) {
            this.left.indexSearch();
        }
        System.out.println("node.id = " + this.id);
        if (this.right != null) {
            this.right.indexSearch();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
