package graph;


import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Graph
 * Package: graph
 * Description:
 * 顶点：vertex
 * 边：edge
 * 路径：
 * 无向图：
 * 有向图
 * 带权图：也称为网
 * 表示方法：
 * 1. 邻接矩阵 -> 二维数组
 * 2. 邻接表 -> 链表
 * @Author jieHFUT
 * @Create 2024/11/4 0:37
 * @Version 1.0
 */

public class Graph {

    // 图节点名称的集合
    private List<String> vertexList;
    // 边的连接表示
    public int[][] edges;
    // 边的数量
    public int numOfEdge;

    // 构造器
    public Graph(int numOfVertex) {
        // 初始化
        edges = new int[numOfVertex][numOfVertex];
        vertexList = new ArrayList<String>(vertexList);
        numOfEdge = 0;
    }



}
