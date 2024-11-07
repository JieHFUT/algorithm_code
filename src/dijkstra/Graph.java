package dijkstra;

import java.lang.reflect.Array;
import java.util.Arrays;

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
    int[][] weights;

    // 构造器
    public Graph(String[] vertexs, int[][] weights) {
        this.vertexs = vertexs;
        this.weights = weights;
    }

    // 显示邻接矩阵
    public void print() {
        for (int[] links : weights) {
            System.out.println(Arrays.toString(links));
        }
    }

    //




}
