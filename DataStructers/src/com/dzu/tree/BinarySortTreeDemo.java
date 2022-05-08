package com.dzu.tree;


/**
 * @author ZhaoDong
 * @date 2022/5/1 19:53
 * @description 128、二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {7, 3, 10, 12, 5, 1, 9, 6, 11, 22, 40, 31, 29, 24, 2, 8};
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
//        binarySortTree.indexSearch();
        System.out.println("binarySortTree.searchNode(1) = " + binarySortTree.searchNode(1));
        System.out.println("binarySortTree.searchNode(1) = " + binarySortTree.searchNodeParent(1));

        binarySortTree.delNode(7);
        binarySortTree.indexSearch();

    }
}

class BinarySortTree {
    private Node root;


    /**
     * 删除节点
     * 三种情况
     *
     * @param id
     */
    public void delNode(int id) {
        if (root == null) {
            return;
        }
        Node node = searchNode(id);
        if (node == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        Node parentNode = searchNodeParent(id);

        // 1、判断要删除的节点是否是叶子节点
        if (node.left == null && node.right == null) {
            if (parentNode.left != null && parentNode.left.id == id) {
                parentNode.left = null;
                return;
            }
            if (parentNode.right != null && parentNode.right.id == id) {
                parentNode.right = null;
                return;
            }
        }

        // 2、判断要删除的节点是否有一颗子树
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
            if (parentNode == null) {
                if (node.left != null) {
                    root = node.left;
                    return;
                }
                root = node.right;
                return;
            }
            if (node.left != null) {
                if (parentNode.left != null && parentNode.left.id == id) {
                    parentNode.left = node.left;
                    return;
                }
                if (parentNode.right != null && parentNode.right.id == id) {
                    parentNode.right = node.left;
                    return;
                }
            }
            if (node.right != null) {
                if (parentNode.right != null && parentNode.right.id == id) {
                    parentNode.right = node.right;
                    return;
                }
                if (parentNode.left != null && parentNode.left.id == id) {
                    parentNode.left = node.right;
                    return;
                }
            }
        }

        // 3、删除有两颗子树的节点
        if (node.right != null && node.left != null) {
            // 通过右子树，就找最小值，若是通过左子树，则找最大值，然后与要删除的节点交换
            node.id = delRightTreeMin(node.right);
        }

    }

    /**
     * 1、找出最小节点的值
     * 2、删除最小节点（删除最小节点时，只满足两种情况，最小节点是叶子节点，或者有右子树）
     *
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node temp = node;

        // 通过循环找出最小的节点（最左边的节点是最小的
        while (temp.left != null) {
            temp = temp.left;
        }
        // 此次删除只有两种情况，要么最小的节点没有右子树，要么只有右子树
        delNode(temp.id);
        return temp.id;
    }

    public Node searchNode(int id) {
        if (root == null) {
            return null;
        }

        return root.searchNode(id);
    }

    public Node searchNodeParent(int id) {
        if (root == null) {
            return null;
        }

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
