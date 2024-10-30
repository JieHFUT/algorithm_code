package huffmancode;

/**
 * ClassName: Node
 * Package: huffmancode
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/31 2:19
 * @Version 1.0
 */
public class Node implements Comparable<Node>{
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", weight=" + weight + "]";
    }

    public void preOrder() {
        System.out.println(this);
        if (left != null)
            left.preOrder();
        if (right != null)
            right.preOrder();
    }


}
