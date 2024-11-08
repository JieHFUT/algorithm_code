package dijkstra;

import java.util.Arrays;

public class VisitedVertex {
    // ��¼���������Ƿ���ʹ�
    public int[] isVisited;
    // ��¼�����·����·�ϣ�ÿһ�������ǰһ��������±�
    public int[] prev;
    // ��¼�ӳ������㵽���������Ѿ�ȷ�������·����ֵ
    public int[] distance;


    /**
     * ͨ�����������ʼ����������
     * @param count ���������
     * @param index ����������±�
     */
    public VisitedVertex(int count, int index) {
        // ���˳��������⣬������ʼ��Ϊδ���ʹ�
        isVisited = new int[count];
        isVisited[index] = 1;
        // ���˳������㵽���������Լ��⣬��������ʼ��Ϊ���޴�
        distance = new int[count];
        Arrays.fill(distance, 65535);
        distance[index] = 0;
        // ��ʼ��ǰ������
        prev = new int[count];
    }

    // ��ĳһ��������������������ܱ߶���ľ�����и��º�ѡ����º���̾���Ķ��㣬��������
    public int getNew() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == 0 && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        // ���� index ���㱻���ʹ�
        isVisited[index] = 1;
        return index;
    }

 }
