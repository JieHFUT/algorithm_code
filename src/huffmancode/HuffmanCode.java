package huffmancode;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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

//        String content = "i like like 893 hu i3ey89 34y98 r2";
//        Node root = createHuffmanTree(content);
//        root.preOrder();
//
//        System.out.println("将哈夫曼树转化为字符对应的编码：");
//        HashMap<Byte, String> map = getHuffmanCodes(root);
//        for (Map.Entry<Byte, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//        System.out.println("将字符串转换为压缩好的 byte 数组: ");
//        // 1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
//        // -88 -65 -56 -65 -56 -65 -55 77 -57 6 -24 -14 -117 -4 -60 -90 28
//        byte[] compressArray = zip(content);
//        for (byte b : compressArray) {
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        System.out.println(decode(map, compressArray));


        // 对文件进行处理
//        zipFile(".//src//huffmancode//luffy.jpg", ".//src//huffmancode//newluffy.jpg");
//        System.out.println("压缩完成~");


    }

    /**
     * 接收字节数组，将其统计字符出现的次数
     * @param bytes
     * @return
     * [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......]
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
    //可以通过List 创建对应的赫夫曼树
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
    // Node [data=null, weight=40]
    // Node [data=null, weight=17]
    // ode [data=null, weight=8]
    // Node [data=108, weight=4] ......
    // 生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    private static HashMap<Byte, String> huffmanCodes = new HashMap<Byte, String>() {};
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
    private static StringBuilder stringBuilder = new StringBuilder();


    public static HashMap<Byte, String> getHuffmanCodes(Node root) {
        // 遍历哈夫曼树
        if (root == null) return null;
        getCodes(root, "", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 所有叶子节点的哈夫曼编码放在 HashMap<Byte, String> 中
     * @param node
     * @param code 01010 001 ...
     * @param stringBuilder
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder(stringBuilder);
        sb.append(code);
        if (node != null) {
            if (node.data == null) {
                // 非叶子节点
                getCodes(node.left, "0", sb);
                getCodes(node.right, "1", sb);
            } else {
                // 是叶子节点
                huffmanCodes.put(node.data, sb.toString());
            }
        }
    }

    // 将输入的字符串变成 01 编码，然后转换为 byte[]
    public static byte[] zip(String content) {
        return zip(content, huffmanCodes);
    }
    public static byte[] zip(String content, Map<Byte, String> huffmanCodes) {
        // 用于拼接 010101010
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = content.getBytes();
        for (byte b : bytes)
            stringBuilder.append(huffmanCodes.get(b));
        // 获得了 010010101010100101001010...
        int len = (stringBuilder.length() + 7) / 8;
        System.out.println(stringBuilder.toString());
        byte[] huffmanCodeBytes = new byte[len];
        // 将 001010010100101... 放进 byte 数组中
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length())
                huffmanCodeBytes[index] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
            else
                huffmanCodeBytes[index] = (byte) Integer.parseInt(stringBuilder.substring(i, i + 8), 2);
            index++;
        }
        return huffmanCodeBytes;
    }







    // 解码
    // 1. 将一个 byte 数据转化为 01010 字符串
    public static String byteToString(boolean flag, byte b) {
        int toChange = b;
        String str = Integer.toBinaryString(toChange);
        // -1 - 11111111 11111111 11111111 11111111 => 11111111 11111111 11111111 11111111
        //  2 - 00000000 00000000 00000000 00000010 => 10
        //  0 - 00000000 00000000 00000000 00000000 => 0
        // 如果 byte 负数，就直接截取后面的8位
        // 如果 byte 是零或者正数，就有可能是 0-7 位二进制数，这个时候就需要补数，但是如果到达最后一个 byte，就不用补数
        if (toChange < 0)
            return str.substring(str.length() - 8);
        else {
            if (flag) {
                // 如果是最后一个 byte，传入 flag 为 true
                return str;
            } else {
                // 需要补数
                toChange |= 256;
                // 00000000 000000000 000000000 00000010 | 256 = 00000000 00000000 00000001 00000010
                // 1 00000010 => 截取后面8个
                str = Integer.toBinaryString(toChange);
                return str.substring(str.length() - 8);
            }
        }
    }


    /**
     *
     * @param huffmanCodes 哈夫曼编码表
     * @param bytes 数据压缩后传递过来的 byte[]
     * @return 解码后的可读的字符串
     */

    public static String decode(Map<Byte, String> huffmanCodes, byte[] bytes) {
        // 先把 byte[] 转化为 01010010100010... 编码
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) {
                // 此时已经是最后一个 byte
                stringBuilder.append(byteToString(true, bytes[i]));
            } else {
                stringBuilder.append(byteToString(false, bytes[i]));
            }
        }
        // stringBuilder : 1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        Map<String, Byte> turnHuffmanCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet())
            turnHuffmanCodes.put(entry.getValue(), entry.getKey());
        // 比对
        List<Byte> bytesList = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int index = 1; // 计数器
            boolean flag = true;
            while (flag) {
                String code = stringBuilder.substring(i, i + index);
                if (turnHuffmanCodes.get(code) == null) {
                    // 没有这个编码方式对应的字符
                    index++;
                } else {
                    // 匹配成功
                    bytesList.add(turnHuffmanCodes.get(code));
                    flag = false;
                }
            }

            i += index;
        }

        int length = bytesList.size();
        byte[] result = new byte[length];

        for (int i = 0; i < length; i++)
            result[i] = bytesList.remove(0);
        return new String(result);
    }


    /**
     * 编写一个方法将一个文件进行压缩
     * @param src
     * @param dest
     */
    public static void zipFile(String src, String dest) {
        // 创建输入流，输出流，对象输出流
        File input = new File(src);
        File output = new File(dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        // 将源文件转化为 byte[]=>string
        try {
            fis = new FileInputStream(input);
            byte[] buffer = new byte[fis.available()];
            String toZip = new String(buffer);
            byte[] toTrans = zip(toZip);

            fos = new FileOutputStream(output);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(toTrans);
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






}
