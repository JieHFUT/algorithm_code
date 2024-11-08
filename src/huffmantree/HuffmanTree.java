package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: HuffmanTree
 * Package: huffmantree
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/30 23:24
 * @Version 1.0
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] huffmanArray = new int[]{1,2,3,4,5};
        Node root = huffmanTree(huffmanArray);
        preOrder(root);
    }
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
            return;
        }
        throw new RuntimeException("tree is empty");
    }

    public static Node huffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<Node>();

        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            // È¡Á½¸ö
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node root = new Node(left.value + right.value);
            root.left = left;
            root.right = right;

            nodes.remove(0);
            nodes.remove(0);

            nodes.add(root);
        }
        return nodes.get(0);
    }
}
