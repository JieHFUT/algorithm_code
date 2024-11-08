package kruskal;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    // ������ʾ�������㲻��ͨ�����
    public static final int INF = 65535;
    // ��������������Ϣ
    private String[] vertexs;
    // �������������֮���Ȩֵ��Ϣ
    private int[][] weights;
    // ������¼�ߵĸ�����������������
    private int linkNum;


    // ͨ�����췽�������г�ʼ��
    public Kruskal(String[] vertexs, int[][] weights) {
        int len = vertexs.length;
        // ��ʼ��������Ϣ
        this.vertexs = new String[len];
        for (int i = 0; i < len; i++) {
            this.vertexs[i] = vertexs[i];
        }
        // ��ʼ���ߵ�Ȩֵ��Ϣ
        this.weights = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                this.weights[i][j] = weights[i][j];
            }
        }
        // ����һ���ж�������
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (this.weights[i][j] != INF) {
                    this.linkNum++;
                }
            }
        }
    }

    // ��ӡ�ڽӱ�
    public void print(){
        for (int i = 0; i < this.weights.length; i++) {
            for (int j = 0; j < this.weights[i].length; j++) {
                System.out.printf("%-7d", this.weights[i][j]);
            }
            System.out.println();
        }
    }

    // ������еı� link[]
    public Link[] getLinks() {
        int index = 0;
        Link[] links = new Link[this.linkNum];
        for (int i = 0; i < this.weights.length; i++) {
            for (int j = i + 1; j < this.weights[i].length; j++) {
                if (this.weights[i][j] != INF) {
                    links[index++] = new Link(this.vertexs[i], this.vertexs[j], this.weights[i][j]);
                }
            }
        }
        return links;
    }
    // �����еı߽�������
    public void sortLinks(Link[] links) {
        Arrays.sort(links, new Comparator<Link>() {
            @Override
            public int compare(Link o1, Link o2) {
                return o1.weight - o2.weight;
            }
        });
    }

    // ���ĳһ�������Ӧ���±�
    public int getIndex(String vertex) {
        for (int i = 0; i < this.vertexs.length; i++) {
            if (this.vertexs[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    // ��ʼ kruskal �㷨

    /**
     * ���ĳһ����������С�������е��յ�
     * @param ends
     * @param index
     * @return
     */
    public int getDest(int[] ends, int index) {
        while (ends[index] != 0) {
            index = ends[index];
        }
        return index;
    }
    /**
     * ��ʼѰ��һ��·������ͨ�����еĶ���
     */
    public Link[] kruskal() {
        // �ж�ÿһ���ڵ���յ������
        int[] ends = new int[this.vertexs.length];
        // ��������ÿ�������һ���ߵķ�������
        int index = 0;
        Link[] ret = new Link[this.vertexs.length - 1];
        // �������õ����еıߵļ���
        Link[] links = this.getLinks();
        sortLinks(links);

        // ��ȡ�����д�ʱ����̱�
        // ÿ�λ��һ���ߣ�һ��Ҫ��ö�����-1���ߣ��������еıߣ����û�в�����·�ͽ�����ӵ� ret ��
        for (int i = 0; i < this.linkNum; i++) {
            // ��øñߵ����������Ӧ���±�
            int prev = getIndex(links[i].start);
            int post = getIndex(links[i].end);
            // ������������Ӧ���յ�
            int prevDest = getDest(ends, prev);
            int postDest = getDest(ends, post);

            // �ж��������Ƿ�������·
            if (prevDest != postDest) {
                // prevDest != postDest ���������·
                // �����յ�
                ends[prevDest] = postDest;
                // �������߷��ص����
                ret[index++] = links[i];
            }
        }
        return ret;
    }



}
