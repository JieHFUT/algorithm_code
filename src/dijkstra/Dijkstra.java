package dijkstra;

import java.util.Arrays;

/**
 * ClassName: Dijkstra
 * Package: dijkstra
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/6 23:27
 * @Version 1.0
 */
public class Dijkstra {
    // ������ʾ������֮�䲻��ͨ
    public static final int N = 65535;
    public static void main(String[] args) {
        // ���ж��������
        String[] vertexs = {"A��", "B��", "C��", "D��", "E��", "F��", "G��"};
        // ��������֮���Ȩֵ
        int[][] weights = new int[vertexs.length][vertexs.length];
        weights[0]=new int[]{N,5,7,N,N,N,2};
        weights[1]=new int[]{5,N,N,9,N,N,3};
        weights[2]=new int[]{7,N,N,N,8,N,N};
        weights[3]=new int[]{N,9,N,N,N,4,N};
        weights[4]=new int[]{N,N,8,N,N,5,4};
        weights[5]=new int[]{N,N,N,4,5,N,6};
        weights[6]=new int[]{2,3,N,N,4,6,N};

        // ����ͼ����
        Graph graph = new Graph(vertexs, weights);
        // Ѱ�ҵ�ĳһ�����㵽������������·��
        graph.dijkstra(2);

    }
}
















