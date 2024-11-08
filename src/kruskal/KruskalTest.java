package kruskal;

import static kruskal.Kruskal.INF;

public class KruskalTest {
    public static void main(String[] args) {
        // ����������Ϣ
        String[] vertexs = {"A��", "B��", "C��", "D��", "E��", "F��", "G��"};
        // ���������֮���Ȩֵ
        int weights[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        Kruskal kruskal = new Kruskal(vertexs, weights);
//        // ���Դ�ӡ�ڽӱ�
//        kruskal.print();
//        // ��ȡ���еıߵ���Ϣ
//        Link[] links = kruskal.getLinks();
//        // �����еı߽�������
//        kruskal.sortLinks(links);
//        System.out.println("�����ı�Ϊ��");
//        for (Link link : links) {
//            System.out.println(link);
//        }
        // ��ʼ���� kruskal �㷨
        Link[] result = kruskal.kruskal();
        for (Link link : result) {
            System.out.printf("��%s��%s��·����%d\n", link.start, link.end, link.weight);
        }
    }
}
