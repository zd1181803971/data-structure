package com.dzu.tree.huffmantree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author ZhaoDong
 * @date 2022/4/10 16:41
 * @description 哈夫曼树
 * https://www.bilibili.com/video/BV1E4411H73v?p=113&spm_id_from=pageDriver
 */
public class HaffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6};
        Node node = createHaffMan(arr);
        node.perOrder();

    }

    /**
     * 创建哈夫曼树
     * @param arr
     * @return 头节点
     */
    private static Node createHaffMan(int[] arr) {
        List<Node> nodeList = new ArrayList<>();
        for (int item : arr) {
            nodeList.add(new Node(item));
        }

        while (nodeList.size() > 1) {

            Collections.sort(nodeList);
            // 权值最小
            Node left = nodeList.get(0);
            // 权值第二小
            Node right = nodeList.get(1);

            // 构建新的二叉树
            Node node = new Node(left.getValue() + right.getValue());
            node.setLeft(left);
            node.setRight(right);

            // 删除处理过的
            nodeList.remove(left);
            nodeList.remove(right);

            // 将parent加入到list
            nodeList.add(node);


        }
        return nodeList.get(0);
    }
}

/**
 * 哈夫曼树节点
 */
class Node implements Comparable<Node> {

    /**
     * 结点权值
     */
    private int value;

    /**
     * 指向左子节点
     */
    private Node left;

    /**
     * 指向右子节点
     */
    private Node right;

    /**
     * 前序遍历
     */
    public void perOrder() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().perOrder();
        }
        if (this.getRight() != null) {
            this.getRight().perOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return value == node.value && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
