package com.dzu.tree.avl;

/**
 * @author ZhaoDong
 * @date 2022/5/4 15:41
 * @description 135、avl 平衡二叉树
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("avlTree.height() = " + avlTree.height());
        System.out.println("avlTree.root.leftHeight() = " + avlTree.root.leftHeight());
        System.out.println("avlTree.root.rightHeight() = " + avlTree.root.rightHeight());
    }
}
class AVLTree {
    public Node root;

    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height();
    }


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

    public int leftHeight() {
        if (this.left == null) {
            return 0;
        }
        return this.left.height();
    }

    public int rightHeight() {
        if (this.right == null) {
            return 0;
        }
        return this.right.height();
    }
    /**
     * 当前节点的高度
     * @return
     */
    public int height(){
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height())
                + 1;
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
