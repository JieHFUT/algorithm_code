package prim;

public class PrimTest {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String[] names = new String[]{"A��", "B��", "C��", "D��", "E��", "F��", "G��"};
        int verxs = names.length;
        int[][] weights = new int[][]{
                {INF,5,7,INF,INF,INF,2},
                {5,INF,INF,9,INF,INF,3},
                {7,INF,INF,INF,8,INF,INF},
                {INF,9,INF,INF,INF,4,INF},
                {INF,INF,8,INF,INF,5,4},
                {INF,INF,INF,4,5,INF,6},
                {2,3,INF,INF,4,6,INF}};
        MGraph graph = new MGraph(verxs);
        // �����ڽӾ���
        MinTree tree = new MinTree();
        tree.createGraph(graph, verxs, names, weights);

        // ͨ���ڽӾ���Ѱ����С��������ָ����ʼ�ڵ㣩
        tree.prim(graph, 0);
    }
}
