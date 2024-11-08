package dijkstra;

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
    // ������������
    String[] vertexs;
    // �ڽӾ���
    int[][] weights;

    VisitedVertex visitedVertex;
    // ������
    public Graph(String[] vertexs, int[][] weights) {
        this.vertexs = vertexs;
        this.weights = weights;
    }

    // ��ʾ�ڽӾ���
    public void print() {
        for (int[] links : weights) {
            System.out.println(Arrays.toString(links));
        }
    }

    // ��ʼ���еϽ�˹�����㷨ʵ��   begin����ʾ���ĸ����㿪ʼѰ�����·��
    public void dijkstra(int begin) {
        // �����������
        visitedVertex = new VisitedVertex(vertexs.length, begin);
        // ���ݿ�ʼ�ڵ����
        update(begin);
        // ����֮��� vertexs.length -1 ����
        for (int i = 1; i < vertexs.length; i++) {
            // �õ��� update ��ĳһ�������������ӵ����̾�����Ǹ�����
            int theNew = visitedVertex.getNew();
            update(theNew);
        }
        showResult(begin);
    }

    // ����ĳһ�����㣬�ڱ������ܱ߶���Ĺ����У����µ�ĳһ���������Сֵ����������ǰ������
    public void update(int index) {
        // len ��������ҪȥѰ�ҵ�ĳһ���ڵ�����·��
        // len = �������㵽 index �����·�� + min{��index����ʱ��index �� i �ľ���}
        int len = 0;
        // �������������Χ�Ķ���
        for (int i = 0; i < weights[index].length; i++) {
            len = visitedVertex.distance[index] + weights[index][i];
            // ����ýڵ� i û�б����ʹ�������len < �ӿ�ʼ�ڵ㵽 i �ľ���
            if (visitedVertex.isVisited[i] == 0
                    && len < visitedVertex.distance[i]){
                // ���³����ڵ㵽�ýڵ� i �ľ���
                visitedVertex.distance[i] = len;
                // ���� i �����ǰ��Ϊ index
                visitedVertex.prev[i] = index;
            }
        }
    }

    // �ṩһ���������ķ���
    // isVisited prev distance
    // ������磺F(8)��A=>G=>F
    public void showResult(int begin) {
        for (int i = 0; i < visitedVertex.isVisited.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vertexs[i]);
            stringBuilder.append("(");
            stringBuilder.append(visitedVertex.distance[i]);
            stringBuilder.append(")��");
            int index = i;
            StringBuilder stringBuilder1 = new StringBuilder();
            while (visitedVertex.prev[index] != begin) {
                stringBuilder1.append(new StringBuilder(vertexs[visitedVertex.prev[index]]).reverse());
                stringBuilder1.append(">=");
                index = visitedVertex.prev[index];
            }
            stringBuilder.append(vertexs[begin]);
            if (visitedVertex.prev[begin] != 0) {
                stringBuilder.append("=>");
            }
            // �����м�·��
            stringBuilder.append(stringBuilder1.reverse());

            stringBuilder.append("=>");
            stringBuilder.append(vertexs[i]);
            System.out.println(stringBuilder);
        }
    }


}
