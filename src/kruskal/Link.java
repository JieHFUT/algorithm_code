package kruskal;


/**
 * ���Ǳߵ��࣬��������һ���ߵ���Ϣ
 */
public class Link {
    // �ߵ����
    public String start;
    // �ߵ��յ�
    public String end;
    // �ߵ�Ȩֵ
    public int weight;

    public Link(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Link{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
