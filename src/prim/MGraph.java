package prim;

// 用来寻找最小生成树的图
public class MGraph {
    // 图的顶点数量
    int verxs;
    // 记录顶点的名称
    String[] names;
    // 用来记录顶点之间的连通情况
    int[][] weight;

    public MGraph(int verxs) {
        // 使用构造器对上面数据进行初始化
        this.verxs = verxs;
        names = new String[verxs];
        weight = new int[verxs][verxs];
    }
}
