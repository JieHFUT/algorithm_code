package dijkstra;

/**
 * ClassName: Graph
 * Package: dijkstra
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/6 23:27
 * @Version 1.0
 */
public class Graph {
    // 顶点数组名称
    String[] vertexs;
    // 邻接矩阵
    int[][] matrix;

    // 构造器
    public Graph(String[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
    }


}
