package graph;


import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Graph
 * Package: graph
 * Description:
 * ���㣺vertex
 * �ߣ�edge
 * ·����
 * ����ͼ��
 * ����ͼ
 * ��Ȩͼ��Ҳ��Ϊ��
 * ��ʾ������
 * 1. �ڽӾ��� -> ��ά����
 * 2. �ڽӱ� -> ����
 * @Author jieHFUT
 * @Create 2024/11/4 0:37
 * @Version 1.0
 */

public class Graph {

    // ͼ�ڵ����Ƶļ���
    private List<String> vertexList;
    // �ߵ����ӱ�ʾ
    public int[][] edges;
    // �ߵ�����
    public int numOfEdge;

    // ������
    public Graph(int numOfVertex) {
        // ��ʼ��
        edges = new int[numOfVertex][numOfVertex];
        vertexList = new ArrayList<String>(vertexList);
        numOfEdge = 0;
    }



}
