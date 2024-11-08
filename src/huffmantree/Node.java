package huffmantree;

/**
 * ClassName: Node
 * Package: huffmantree
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/30 23:23
 * @Version 1.0
 */
public class Node implements Comparable<Node>{
    public int value;
    public Node left;
    public Node right;
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    // ���մ�С��������
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    // ����
    public void preOrder() {
        System.out.println(this.value);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }
}
