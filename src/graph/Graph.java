package graph;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
    // ��¼ĳһ���ڵ��Ƿ񱻷��ʹ�
    public boolean[] isVisited;

    // ������
    public Graph(int numOfVertex) {
        // ��ʼ��
        isVisited = new boolean[numOfVertex];
        edges = new int[numOfVertex][numOfVertex];
        vertexList = new ArrayList<String>(numOfVertex);
        numOfEdge = 0;
    }

    // ����ڵ�
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * ����ͼ��ӱ�
     * @param from ��ʼ�ڵ�
     * @param to ָ��ڵ�
     * @param weight Ȩ��
     */
    public void insertEdge(int from, int to, int weight) {
        edges[from - 1][to - 1] = weight;
        edges[to - 1][from - 1] = weight;
        numOfEdge++;
    }



    // ����ĳһ�����������
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }
    // ���ض���ĸ���
    public int getNumOfVertex() {
        return vertexList.size();
    }
    // ���رߵ�����
    public int getNumOfEdge() { return numOfEdge; }
    // ���������ڵ�֮���Ȩֵ
    public int getWeight(int from, int to) {
        return edges[from][to];
    }


    // ��ӡ����
    public void printGraph() {
        for (int[] vertexOfEdge : edges) {
            System.out.println(Arrays.toString(vertexOfEdge));
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////

    // ���ҵ�һ���ڽӽڵ���±�
    public int getFirstNeighbor(int vertex) {
        for (int i = 0; i < edges[vertex - 1].length; i++) {
            if (edges[vertex - 1][i] > 0) {
                // ˵���ü����ҵ��������ӵĽڵ�
                return i + 1;
            }
        }
        return -1;
    }

    // ����ǰһ���ڽӽڵ���±�����ȡ��һ���ڽӽڵ�
    public int getNextNeighbor(int vertex, int prevNeighbor) {
        for (int i = prevNeighbor; i < edges[vertex - 1].length; i++) {
            if (edges[vertex - 1][i] > 0) {
                return i + 1;
            }
        }
        return -1;
    }

    // ������ȱ����㷨
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(i + 1, isVisited);
            }
        }
        System.out.println();
    }
    public void dfs(int vertex, boolean[] isVisited) {
        // ��һ�ξ��ǵ�һ���ڵ� vertex = 1
        isVisited[vertex - 1] = true;
        System.out.print(getValueByIndex(vertex - 1) + " ");
        int neighbor = getFirstNeighbor(vertex);
        while (neighbor != -1) {
            // ���ڽӽڵ�
            if (!isVisited[neighbor - 1]) {
                dfs(neighbor, isVisited);
            } else {
                neighbor = getNextNeighbor(vertex, neighbor);
            }
        }
    }




    // ������ȱ��� ʹ��һ�����б��ַ��ʹ��Ľڵ��˳��
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i + 1);
            }
        }
        System.out.println();
    }
    public void bfs(boolean[] isVisited, int vertex) {
        // ���У�������¼���ʽڵ��˳��
        LinkedList<Integer> queue = new LinkedList();
        // ��ӡ��ǰ�ڵ�
        System.out.print(getValueByIndex(vertex - 1) + " ");
        isVisited[vertex - 1] = true;
        // ��ǰ�ڵ������
        queue.addLast(vertex);
        while (!queue.isEmpty()) {
            int current = queue.removeFirst();
            // ��ȡ��һ���ڽӽڵ�
            int neighbor = getFirstNeighbor(current);

            while (neighbor != -1) {
                if (!isVisited[neighbor - 1]) {
                    // ��ǰ�ڵ���ڽӽڵ�û�� visited
                    System.out.print(getValueByIndex(neighbor - 1) + " ");
                    // �ڽӽڵ������
                    queue.addLast(neighbor);
                    isVisited[neighbor - 1] = true;
                } else {
                    // ��ǰ�ڵ�����ڽӽڵ㱻 visited
                    int nextNeighbor = getNextNeighbor(current, neighbor);
                    neighbor = nextNeighbor;
                }
            }
            // ��ǰ�ڵ�û���ڽӽڵ� return
        }
    }

}
