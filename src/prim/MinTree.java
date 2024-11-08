package prim;

import java.util.Arrays;


// ����������С������
public class MinTree {


    /**
     * �������ݹ����ڽӾ���
     * @param graph ͼ��ʵ��
     * @param verxs �������
     * @param names  ��������
     * @param weight Ȩֵ
     */
    public void createGraph(MGraph graph, int verxs, String[] names, int[][] weight) {
        // �ڴ��� MGraph graph ʱ����ͼ�� verxs �Ѿ���ֵ
        for (int i = 0; i < verxs; i++) {
            graph.names[i] = names[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    // ����ڽӱ�
    public void printGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }


    // ��ʼ������С������
    public void prim(MGraph graph, int begin) {
        // ���ڼ�¼ĳһ��������û�б�ʹ�ù�  0��ʾû��ʹ�ù� 1��ʾ��ʹ�ù�
        int[] visited = new int[graph.verxs];
        // ���ȼ�¼����Ŀ�ʼ���� => ��ʹ��
        visited[begin] = 1;
        int m = -1;
        int n = -1; // m �� n ��������һ��Ѱ�����·���������漰������������
        // һ��Ҫ�ҵ� verxs - 1 ����
        for (int i = 1; i < graph.verxs; i++) {
            int toFindMinPath = PrimTest.INF; // Ѱ��ÿ�����·��ʱ������¼���·����ֵ
            // ÿ������һ���� => ���Ѿ���ʹ�ù��Ķ����δ��ʹ�ù��Ķ���֮�� => �ҵ�һ�����·��
            for (int j = 0; j < graph.verxs; j++) { // ��������ɸѡ => ѡ��ʹ�ù��Ķ���
                for (int k = 0; k < graph.verxs; k++) { // ��������ɸѡ => ѡ��û��ʹ�ù��Ķ���
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < toFindMinPath) {
                        // �ҵ��ȼ�¼��̵�ֵС��·��
                        toFindMinPath = graph.weight[j][k];
                        m = j;
                        n = k;
                    }
                }
            }
            // �ҵ����·�� i => j
            System.out.printf("��%s��%s ·�����ȣ�%d\n", graph.names[m], graph.names[n], toFindMinPath);
            visited[n] = 1;
            toFindMinPath = PrimTest.INF;
            m = -1;
            n = -1;
        }
    }



}
