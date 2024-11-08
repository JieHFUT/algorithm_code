package floyd;

import java.util.Arrays;

/**
 * ClassName: Graph
 * Package: floyd
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/7 21:34
 * @Version 1.0
 */

// ����ͼ
public class Graph {
    // ��Ŷ��������
    String[] vertexs;
    // �����������Ķ�ά����
    int[][] distance;
    // ������¼ǰ���Ķ�ά����
    int[][] prev;
    // ��ʾ�������㲻��ͨ
    public static final int N = 65535;


    // ���췽��������г�ʼ��
    public Graph(int count, String[] vertexs, int[][] distance) {
        this.vertexs = vertexs;
        this.distance = distance;
        this.prev = new int[vertexs.length][vertexs.length];
        // ��ǰ���ڵ���г�ʼ��
        for (int i = 0; i < count; i++) {
            Arrays.fill(this.prev[i], i);
        }
    }

    // ��ӡ�����������¼
    // 1.������¼ʵʱ��̾���� distance ����
    // 2.������¼ʵʱ��ǰ������� prev ����
    public void print() {
        for (int[] dis : distance) {
            System.out.println(Arrays.toString(dis));
        }
        System.out.println("������ǰ������������");
        for (int[] pre : prev) {
            System.out.println(Arrays.toString(pre));
        }
    }


    // ��ʼͨ�����������㷨Ѱ�Ҹ���·��
    // ǰ������ ==> �м䶥�� ==> �յ�
    public void floyd() {
        // ÿ�����㶼Ҫ�䵱һ���м䶥�㣬һ�� vertexs.length ��
        for (int k = 0; k < this.vertexs.length; k++) {
            // ����м䶥���ܱߵ�ǰ������
            for (int i = 0; i < this.vertexs.length; i++) {
                // ����м䶥���ܱߵĺ�̶���
                for (int j = 0; j < this.vertexs.length; j++) {
                    // ԭ����¼��ǰ�����㵽��̶���ľ���
                    int init = distance[i][j];
                    // ǰ������ͨ������ת���㵽��̶���ľ���
                    int len = distance[i][k] + distance[k][j];
                    if (len < init) {
                        // ��ǰ�����㵽��̶���ľ�������޸�
                        distance[i][j] = len;
                        // ����ǰ��������������޸�
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }

        // ������
        result();
    }

    public void result() {
        for (int i = 0; i < distance.length; i++) {
            for (int j = i; j < distance.length; j++) {
                System.out.printf("%s��%s����̾���Ϊ:%d\t", vertexs[i], vertexs[j], distance[i][j]);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(vertexs[i] + "=>");
                int m = i;
                int n = j;
                while(m < distance.length && prev[n][m] != prev[n][prev[n][m]]) {
                    String path = vertexs[prev[n][m]];
                    stringBuilder.append(path + "=>");
                    m = prev[n][m];
                }
                stringBuilder.append(vertexs[j]);
                System.out.printf("·��Ϊ:%s\n", stringBuilder);
                System.out.println("====================================");
            }
        }
    }



}
