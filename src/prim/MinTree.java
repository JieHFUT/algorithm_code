package prim;

import java.util.Arrays;


// 用来构造最小生成树
public class MinTree {


    /**
     * 传入数据构造邻接矩阵
     * @param graph 图的实体
     * @param verxs 顶点个数
     * @param names  顶点名称
     * @param weight 权值
     */
    public void createGraph(MGraph graph, int verxs, String[] names, int[][] weight) {
        // 在传入 MGraph graph 时，其图的 verxs 已经赋值
        for (int i = 0; i < verxs; i++) {
            graph.names[i] = names[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 输出邻接表
    public void printGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }


    // 开始构建最小生成树
    public void prim(MGraph graph, int begin) {
        // 用于记录某一个顶点有没有被使用过  0表示没被使用过 1表示被使用过
        int[] visited = new int[graph.verxs];
        // 首先记录传入的开始顶点 => 被使用
        visited[begin] = 1;
        int m = -1;
        int n = -1; // m 和 n 用来保存一次寻找最短路径过程中涉及到的两个顶点
        // 一共要找到 verxs - 1 条边
        for (int i = 1; i < graph.verxs; i++) {
            int toFindMinPath = PrimTest.INF; // 寻找每次最短路径时用来记录最短路径的值
            // 每次锁定一条边 => 在已经被使用过的顶点和未被使用过的顶点之间 => 找到一条最短路径
            for (int j = 0; j < graph.verxs; j++) { // 用来遍历筛选 => 选出使用过的顶点
                for (int k = 0; k < graph.verxs; k++) { // 用来遍历筛选 => 选出没有使用过的顶点
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < toFindMinPath) {
                        // 找到比记录最短的值小的路径
                        toFindMinPath = graph.weight[j][k];
                        m = j;
                        n = k;
                    }
                }
            }
            // 找到最短路径 i => j
            System.out.printf("从%s到%s 路径长度：%d\n", graph.names[m], graph.names[n], toFindMinPath);
            visited[n] = 1;
            toFindMinPath = PrimTest.INF;
            m = -1;
            n = -1;
        }
    }



}
