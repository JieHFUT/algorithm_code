package huffmancode;

import java.util.*;

/**
 * ClassName: HuffmanCode
 * Package: huffmancode
 * Description:
 * 哈夫曼编码
 * @Author jieHFUT
 * @Create 2024/10/31 2:19
 * @Version 1.0
 */
public class HuffmanCode {
    public static void main(String[] args) {

        String content = "i like like like java do you like a java";
        Node root = createHuffmanTree(content);
        root.preOrder();
    }

    /**
     * 接收字节数组，将其统计字符出现的次数
     * @param bytes
     * @return
     */
    public static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<Node>();

        HashMap<Byte, Integer> map = new HashMap<>();
        // 用 hashmap 存储出现的字符和它出现的次数
        for(Byte b : bytes) {
            // 如果某一个字符还没有存过，就将其数量置为 1
            if (map.get(b) == null)
                map.put(b, 1);
            else map.put(b, map.get(b) + 1);
        }
        // 此时 map 中已经存储了对应的 字符-字符数量
        //         将其存储到node中: data-weight
        // Set entrySet()：返回所有key-value对构成的Set集合
        Set<Map.Entry<Byte, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Byte, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            nodes.add(node);
        }
        return nodes;
    }

    public static Node createHuffmanTree(String content) {
        byte[] bytes = content.getBytes();
        List<Node> nodes = getNodes(bytes);
        // 凭借 nodes 构建哈夫曼树
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }
        return nodes.get(0);
    }


    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    //   生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
    


}
