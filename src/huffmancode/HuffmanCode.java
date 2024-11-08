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
 * ����������
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
//        System.out.println("����������ת��Ϊ�ַ���Ӧ�ı��룺");
//        HashMap<Byte, String> map = getHuffmanCodes(root);
//        for (Map.Entry<Byte, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//        System.out.println("���ַ���ת��Ϊѹ���õ� byte ����: ");
//        // 1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
//        // -88 -65 -56 -65 -56 -65 -55 77 -57 6 -24 -14 -117 -4 -60 -90 28
//        byte[] compressArray = zip(content);
//        for (byte b : compressArray) {
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        System.out.println(decode(map, compressArray));


        // ���ļ����д���
//        zipFile(".//src//huffmancode//luffy.jpg", ".//src//huffmancode//newluffy.jpg");
//        System.out.println("ѹ�����~");


    }

    /**
     * �����ֽ����飬����ͳ���ַ����ֵĴ���
     * @param bytes
     * @return
     * [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......]
     */
    public static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<Node>();

        HashMap<Byte, Integer> map = new HashMap<>();
        // �� hashmap �洢���ֵ��ַ��������ֵĴ���
        for(Byte b : bytes) {
            // ���ĳһ���ַ���û�д�����ͽ���������Ϊ 1
            if (map.get(b) == null)
                map.put(b, 1);
            else map.put(b, map.get(b) + 1);
        }
        // ��ʱ map ���Ѿ��洢�˶�Ӧ�� �ַ�-�ַ�����
        //         ����洢��node��: data-weight
        // Set entrySet()����������key-value�Թ��ɵ�Set����
        Set<Map.Entry<Byte, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Byte, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            nodes.add(node);
        }
        return nodes;
    }
    //����ͨ��List ������Ӧ�ĺշ�����
    public static Node createHuffmanTree(String content) {
        byte[] bytes = content.getBytes();
        List<Node> nodes = getNodes(bytes);
        // ƾ�� nodes ������������
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

    //���ɺշ�������Ӧ�ĺշ�������
    //˼·:
    //1. ���շ������������ Map<Byte,String> ��ʽ
    // Node [data=null, weight=40]
    // Node [data=null, weight=17]
    // ode [data=null, weight=8]
    // Node [data=108, weight=4] ......
    // ���ɵĺշ��������{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    private static HashMap<Byte, String> huffmanCodes = new HashMap<Byte, String>() {};
    //2. �����ɺշ��������ʾ����Ҫȥƴ��·��, ����һ��StringBuilder �洢ĳ��Ҷ�ӽ���·��
    private static StringBuilder stringBuilder = new StringBuilder();


    public static HashMap<Byte, String> getHuffmanCodes(Node root) {
        // ������������
        if (root == null) return null;
        getCodes(root, "", stringBuilder);
        return huffmanCodes;
    }

    /**
     * ����Ҷ�ӽڵ�Ĺ������������ HashMap<Byte, String> ��
     * @param node
     * @param code 01010 001 ...
     * @param stringBuilder
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder(stringBuilder);
        sb.append(code);
        if (node != null) {
            if (node.data == null) {
                // ��Ҷ�ӽڵ�
                getCodes(node.left, "0", sb);
                getCodes(node.right, "1", sb);
            } else {
                // ��Ҷ�ӽڵ�
                huffmanCodes.put(node.data, sb.toString());
            }
        }
    }

    // ��������ַ������ 01 ���룬Ȼ��ת��Ϊ byte[]
    public static byte[] zip(String content) {
        return zip(content, huffmanCodes);
    }
    public static byte[] zip(String content, Map<Byte, String> huffmanCodes) {
        // ����ƴ�� 010101010
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = content.getBytes();
        for (byte b : bytes)
            stringBuilder.append(huffmanCodes.get(b));
        // ����� 010010101010100101001010...
        int len = (stringBuilder.length() + 7) / 8;
        System.out.println(stringBuilder.toString());
        byte[] huffmanCodeBytes = new byte[len];
        // �� 001010010100101... �Ž� byte ������
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







    // ����
    // 1. ��һ�� byte ����ת��Ϊ 01010 �ַ���
    public static String byteToString(boolean flag, byte b) {
        int toChange = b;
        String str = Integer.toBinaryString(toChange);
        // -1 - 11111111 11111111 11111111 11111111 => 11111111 11111111 11111111 11111111
        //  2 - 00000000 00000000 00000000 00000010 => 10
        //  0 - 00000000 00000000 00000000 00000000 => 0
        // ��� byte ��������ֱ�ӽ�ȡ�����8λ
        // ��� byte ����������������п����� 0-7 λ�������������ʱ�����Ҫ��������������������һ�� byte���Ͳ��ò���
        if (toChange < 0)
            return str.substring(str.length() - 8);
        else {
            if (flag) {
                // ��������һ�� byte������ flag Ϊ true
                return str;
            } else {
                // ��Ҫ����
                toChange |= 256;
                // 00000000 000000000 000000000 00000010 | 256 = 00000000 00000000 00000001 00000010
                // 1 00000010 => ��ȡ����8��
                str = Integer.toBinaryString(toChange);
                return str.substring(str.length() - 8);
            }
        }
    }


    /**
     *
     * @param huffmanCodes �����������
     * @param bytes ����ѹ���󴫵ݹ����� byte[]
     * @return �����Ŀɶ����ַ���
     */

    public static String decode(Map<Byte, String> huffmanCodes, byte[] bytes) {
        // �Ȱ� byte[] ת��Ϊ 01010010100010... ����
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) {
                // ��ʱ�Ѿ������һ�� byte
                stringBuilder.append(byteToString(true, bytes[i]));
            } else {
                stringBuilder.append(byteToString(false, bytes[i]));
            }
        }
        // stringBuilder : 1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        Map<String, Byte> turnHuffmanCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet())
            turnHuffmanCodes.put(entry.getValue(), entry.getKey());
        // �ȶ�
        List<Byte> bytesList = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int index = 1; // ������
            boolean flag = true;
            while (flag) {
                String code = stringBuilder.substring(i, i + index);
                if (turnHuffmanCodes.get(code) == null) {
                    // û��������뷽ʽ��Ӧ���ַ�
                    index++;
                } else {
                    // ƥ��ɹ�
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
     * ��дһ��������һ���ļ�����ѹ��
     * @param src
     * @param dest
     */
    public static void zipFile(String src, String dest) {
        // ����������������������������
        File input = new File(src);
        File output = new File(dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        // ��Դ�ļ�ת��Ϊ byte[]=>string
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
