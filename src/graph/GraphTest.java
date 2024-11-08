package graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        // ��������ͼ�Ķ���
        String[] vertexs = {"1.����", "2.���", "3.����", "4.�Ϻ�", "5.����"};
        for (int i = 0; i < vertexs.length; i++) {
            graph.insertVertex(vertexs[i]);
        }
        // ��������ͼ�ı�
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,5,1);
        graph.insertEdge(2,3,1);
        graph.insertEdge(2,4,1);
        graph.insertEdge(3,4,1);
        // ��ӡ����
        System.out.println("����ͼ����Ϊ: ");
        graph.printGraph();
        System.out.println("������ȱ������Ϊ��");
        graph.dfs();

        System.out.println("������ȱ������Ϊ��");
        graph.bfs();
    }
}
