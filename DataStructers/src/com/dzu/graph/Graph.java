package com.dzu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhaoDong
 * @date 2022/5/22 13:46
 * @description 图
 */
public class Graph {

    /**
     * 存储顶点集合
     */
    private List<String> vertexList;

    /**
     * 存储图对应的邻结矩阵
     */
    private int[][] edges;

    /**
     * 存储边的数目
     */
    private int numOfEdges;

    public static void main(String[] args) {
        // 结点的个数
        int n = 5;
        String[] vertex = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String str : vertex) {
            graph.insertVertex(str);
        }
        // 添加边
        // A-B A-C B-c B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();


    }

    public Graph(int n) {
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>(n);
        this.numOfEdges = 0;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }
    public int getNumOfEdges() {
        return numOfEdges;
    }
    public void showGraph() {
        System.out.print(" ");
        System.out.println(vertexList);
        for (int i = 0; i < edges.length; i++) {
            System.out.print(vertexList.get(i));
            System.out.println(Arrays.toString(edges[i]));
        }
    }

    /**
     * 返回v1和v2的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 返回结点下标对应的数据
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 插入节点
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 从一个顶点到另一个顶点的权重
     * @param v2
     * @param weight 0或者1
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }


}
