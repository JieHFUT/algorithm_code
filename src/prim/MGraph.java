package prim;

// ����Ѱ����С��������ͼ
public class MGraph {
    // ͼ�Ķ�������
    int verxs;
    // ��¼���������
    String[] names;
    // ������¼����֮�����ͨ���
    int[][] weight;

    public MGraph(int verxs) {
        // ʹ�ù��������������ݽ��г�ʼ��
        this.verxs = verxs;
        names = new String[verxs];
        weight = new int[verxs][verxs];
    }
}
