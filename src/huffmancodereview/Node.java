package huffmancodereview;

public class Node implements Comparable<Node>{
    // ����
    Byte value;
    // Ȩ��
    int weight;
    // ���ҽڵ�
    Node left;
    Node right;
    public Node(Byte value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    // ��������
    public void preOrder() {
        System.out.println("�ýڵ��Ȩ����: " + this.weight);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }


    @Override
    public String toString() {
        return "Node [value=" + value + ", weight=" + weight + "]";
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
