package huffmancodereview;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        // ѹ�� => ��ѹ
        String content =
                "���Ƿֲ�ʽ�汾����ϵͳ��Distributed Version Control System����� DVCS�������ˡ� ������ϵͳ�У���\n" +
                "���Ƿֲ�ʽ�汾����ϵͳ��Distributed Version Control System����� DVCS�������ˡ� ������ϵͳ�У���\n" +
                "Git��Mercurial �Լ� Darcs �ȣ��ͻ��˲���ֻ��ȡ���°汾���ļ����գ� ���ǰѴ���ֿ������ؾ�����������\n" +
                "Git��Mercurial �Լ� Darcs �ȣ��ͻ��˲���ֻ��ȡ���°汾���ļ����գ� ���ǰѴ���ֿ������ؾ�����������\n" +
                "����������ʷ��¼�� ��ôһ�����κ�һ��Эͬ�����õķ������������ϣ��º󶼿������κ�һ����������ı�\n" +
                "����������ʷ��¼�� ��ôһ�����κ�һ��Эͬ�����õķ������������ϣ��º󶼿������κ�һ����������ı�\n" +
                "���Ƿֲ�ʽ�汾����ϵͳ��Distributed Version Control System����� DVCS�������ˡ� ������ϵͳ�У���\n" +
                "���Ƿֲ�ʽ�汾����ϵͳ��Distributed Version Control System����� DVCS�������ˡ� ������ϵͳ�У���\n" +
                "Git��Mercurial �Լ� Darcs �ȣ��ͻ��˲���ֻ��ȡ���°汾���ļ����գ� ���ǰѴ���ֿ������ؾ�����������\n" +
                "Git��Mercurial �Լ� Darcs �ȣ��ͻ��˲���ֻ��ȡ���°汾���ļ����գ� ���ǰѴ���ֿ������ؾ�����������\n" +
                "����������ʷ��¼�� ��ôһ�����κ�һ��Эͬ�����õķ������������ϣ��º󶼿������κ�һ����������ı�\n" +
                "����������ʷ��¼�� ��ôһ�����κ�һ��Эͬ�����õķ������������ϣ��º󶼿������κ�һ����������ı�\n" +
                "�زֿ�ָ��� ��Ϊÿһ�εĿ�¡������ʵ���϶���һ�ζԴ���ֿ���������ݡ�";

        byte[] input = content.getBytes();
        System.out.println("����õ����ֽ�����Ϊ��");
        System.out.println(Arrays.toString(input));

        List<Node> nodes = statistics(input);
        System.out.println("ͳ�Ƶĸ����ַ����ֵ�����Ϊ��");
        for (Node node : nodes)
            System.out.println(node);

        Node root = createHuffmanTree(nodes);
        System.out.println("����Ĺ�������Ϊ��");
        root.preOrder();

        System.out.println("�õ��Ĺ���������Ϊ��");
        Map<Byte, String> huffmanCodes = getHuffmanCodes(root);
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("�����õ��Ĵ����������0101001��Ϊ��");

        // zip ����ѹ����� 01 ����ת��Ϊ��������ֽ�����
        System.out.println("01010... ת���Ĵ����͵��ֽ�����Ϊ��");
        byte[] zip = compress(input, huffmanCodes);
        System.out.println(Arrays.toString(zip));

        System.out.println("ѹ����Ϊ��" + input.length + " " + zip.length);

        // ��ѹ
        System.out.println("��ѹ��õ���0101001010...����Ϊ��");

        System.out.println("��ѹ��õ���010010100...ƥ��õ���byte�����ǣ�");
        byte[] decodeBytes = decode(zip);
        System.out.println(Arrays.toString(decodeBytes));
        // byte[] ת string
        String result = new String(decodeBytes);
        System.out.println(result);
    }


    // ��ѹ���ļ��Ĺ�������
    public static byte[] zip(byte[] input) {
        // ͳ�Ƹ����ַ����ֵĴ���
        List<Node> nodeList = statistics(input);
        // ������������
        Node root = createHuffmanTree(nodeList);
        // ������������
        Map<Byte, String> huffmanCodes = getHuffmanCodes(root);
        // ���ѹ������Ҫ����� byte[]
        byte[] zipBytes = compress(input, huffmanCodes);
        // ����
        return zipBytes;
    }




    // ���ݴ���� byte[] ͳ�Ƹ����ַ����ֵĴ������� Node [value, weight] ������ʽ���
    public static List<Node> statistics(byte[] input) {
        Map<Byte, Integer> map = new HashMap<>();
        for (Byte b : input) {
            Integer weight = map.get(b);
            if (weight == null) {
                // ˵����ϣ���л�û����ӹ������ַ�
                map.put(b, 1);
            } else {
                // ˵����ϣ�����Ѿ���ӹ������ַ�
                map.put(b, weight + 1);
            }
        }
        // ����ϣ���� key ��Ϊ null ��Ԫ�ؼ��뼯����
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                nodes.add(new Node(entry.getKey(), entry.getValue()));
            }
        }
        return nodes;
    }

    // �Եõ��� List<Node> �� weight ���� huffmanTree
    public static Node createHuffmanTree(List<Node> nodes) {
        // ÿ��ѡ�� weight ��С����������
        while (nodes.size() > 1) {
            // ��������ϸ��� weight ��������
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null, left.weight + right.weight);
            // ȡ����С�������ٽ��ϳɵķŽ�ȥ��������
            parent.left = left;
            parent.right = right;


            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        // ʣ�µľ��ǹ��� �������� �ĸ��ڵ�
        return nodes.get(0);
    }


    // ���ݹ����Ĺ����������������������
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * ���������������
     * @param root ���������ĸ��ڵ�
     * @param code ÿ��������һ��һ���ַ���ӵ� ��0�� ���� ��1��
     * @param stringBuilder ������¼�Ӹ��ڵ㵽ĳһ��Ҷ�ӵ� 0101001 ����
     * @return
     */
    public static void getHuffmanCodes(Node root, String code, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder(stringBuilder);

        sb.append(code);
        if (root.value == null) {
            // ˵����������ڵ㲻��Ҷ�ӽڵ�
            if (root.left != null)
                getHuffmanCodes(root.left, "0", sb);
            if (root.right != null)
                getHuffmanCodes(root.right, "1", sb);
        } else {
            // ˵����������ڵ���Ҷ�ӽڵ�, ���ýڵ��ַ� �� ·������ŵ�map��
            huffmanCodes.put(root.value, sb.toString());
        }
    }

    // �򻯴���ı���
    public static Map<Byte, String> getHuffmanCodes(Node root) {
        if (root == null) return null;
        getHuffmanCodes(root, "", stringBuilder);
        return huffmanCodes;
    }

    // ������Ҫѹ������Դת���ɵ� byte[] ���ݹ��������� huffmanCodes ѹ���� 01010010100101010 ����
    // �ٽ� 010100100101010 ת��Ϊ byte[] �洢��Ȼ��ͨ�����緢��
    public static byte[] compress(byte[] input) {
        return compress(input, huffmanCodes);
    }
    // ѹ��
    public static byte[] compress(byte[] input, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte b : input) {
            String code = huffmanCodes.get(b);
            stringBuilder.append(code);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////// ���Ǵ����͵�0101001001...��
        //////////////////////////////////////////////////////////////////////////////////////////////////
        //System.out.println(stringBuilder.toString());
        // �� 010101001010010010000101001010... ת��Ϊ byte[]
        byte[] zip = new byte[(stringBuilder.length() + 7) / 8];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String str;
            if (i + 8 >= stringBuilder.length()) {
                str = stringBuilder.substring(i);
            } else {
                str = stringBuilder.substring(i, i + 8);
            }
            zip[index++] = (byte) Integer.parseInt(str, 2);
        }
        return zip;
    }


    @Test
    public void test3(){
        // 00001011_10011001_10011111_00101101_11010110_11100
        System.out.println((byte) Integer.parseInt("00001011", 2));
        System.out.println((byte) Integer.parseInt("10011001", 2));
        System.out.println((byte) Integer.parseInt("10011111", 2));
        System.out.println((byte) Integer.parseInt("00101101", 2));
        System.out.println((byte) Integer.parseInt("11010110", 2));
        System.out.println((byte) Integer.parseInt("11100", 2));
        // 11 -103 -97 45 -42 28
    }





























    @Test
    public void test4(){
        // 11 -103 -97 45 -42 28
        byte[] decodeBytes= decode(new byte[]{11, -103, -97, 45, -42, 28});
        System.out.println(Arrays.toString(decodeBytes));
        // ����õ��ģ�000010111001100110011111001011011101011011100
        // ����õ��ģ�000010111001100110011111001011011101011011100
    }


    // ���룬���ݴ���ľ�������� byte[]����������Ϣת��Ϊ 010100101...
    // �ٸ��� 01 ����ƥ��������������Ϊԭ���� byte[]
    public static byte[] decode(byte[] zip) {
        return decode(zip, huffmanCodes);
    }
    public static byte[] decode(byte[] zip, Map<Byte, String> huffmanCodes) {
        // ת��Ϊ 01010100...
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zip.length; i++) {
            if (i == zip.length - 1) {
                // ���һ�����ܲ��� 8 λ
                str = byteToString(true, zip[i]);
            } else {
                str = byteToString(false, zip[i]);
            }
            stringBuilder.append(str);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////// ���Ǵ����͵�0101001001...��
        //////////////////////////////////////////////////////////////////////////////////////////////////
        //System.out.println(stringBuilder.toString());
        // ��ʱ���»�� 0100101010111010101001010100101001010100100100001010101100010010100...
        // ����һ�� 01 ����͹�������ƥ�䣬ƥ�䵽�Ľ�����ڼ�����
        List<Byte> decodeResult = new ArrayList<>();
        Map<String, Byte> toSearchHuffmanCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet())
            toSearchHuffmanCodes.put(entry.getValue(), entry.getKey());

        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                // ƥ�䵽�˾ͽ���ѭ��
                String toSearch = stringBuilder.substring(i, i + count);
                if (toSearchHuffmanCodes.get(toSearch) == null) {
                    // û��ƥ�䵽
                    count++;
                } else {
                    // ƥ�䵽��
                    flag = false;
                    decodeResult.add(toSearchHuffmanCodes.get(toSearch));
                }
            }
            i = i + count;
        }
        // �Ѿ��ѽ���� byte[] ���ڼ�����
        int index = 0;
        byte[] decodedBytes = new byte[decodeResult.size()];
        for (Byte b : decodeResult)
            decodedBytes[index++] = b;
        return decodedBytes;
    }


    @Test
    public void test2(){
        System.out.println(Integer.toBinaryString(1)); // 1
        System.out.println(Integer.toBinaryString(-1)); // 11111111_11111111_11111111_11111111
        System.out.println(Integer.toBinaryString(-1).substring(32 - 8)); // 11111111
        System.out.println(Integer.toBinaryString(1 | 256)); // 1_00000001
        System.out.println(Integer.toBinaryString(1 | 256).substring(9 - 8)); // 00000001
    }
    public static String byteToString(boolean flag, byte codeByte) {
        int code = codeByte;
        if (flag) {
            // ���ܲ��� 8 λ
            return Integer.toBinaryString(code);
        } else {
            String str = Integer.toBinaryString(code |= 256);
            return str.substring(str.length() - 8);
        }
    }


    @Test
    public void test(){
        System.out.println(Integer.parseInt("01111111", 2)); // 127
        System.out.println(Integer.parseInt("111", 2)); // 7
        System.out.println(Integer.parseInt("11111111", 2));// 255
        System.out.println(Integer.parseInt("01111111111111111111111111111111", 2));// 2147483647
        System.out.println(Integer.parseInt("10000000000000000000000000000000", 2));// NumberFormatException
        System.out.println(Integer.parseInt("10000000000000000000000000000001", 2));// NumberFormatException
        // 1000000000000000000000000000001 => 10000000000000000000000000000000 => 11111111111111111111111111111111 => -2147483647
        System.out.println(Integer.parseInt("11111111111111111111111111111111", 2));// NumberFormatException
    }
    @Test
    public void test1(){
        System.out.println(Integer.parseInt("01010011", 2)); // 83
        System.out.println(Integer.parseInt("10101101", 2)); // 173
        System.out.println(Integer.parseInt("101010011", 2)); // 339
        System.out.println(Integer.parseInt("110101101", 2)); // 429


        System.out.println((byte) Integer.parseInt("01010011", 2)); // 83
        // 10101101 ���룺10101101  ����:10101100  ԭ��:11010011     ԭ��=> -83
        System.out.println((byte) Integer.parseInt("10101101", 2)); // -83
        System.out.println((byte) Integer.parseInt("101010011", 2)); // 83
        System.out.println((byte) Integer.parseInt("110101101", 2)); // -83
    }


















    @Test
    public void zip(){
        zip(".//src//huffmancodereview//sun.bmp", ".//src//huffmancodereview//compress.huf");
        System.out.println("ѹ�����~");
    }
    @Test
    public void decode(){
        decode(".//src//huffmancodereview//compress.huf", ".//src//huffmancodereview//decode.bmp");
        System.out.println("��ѹ���~");
    }

    @Test
    public void zipVideo(){
        zip(".//src//huffmancodereview//tocompress.mp4", ".//src//huffmancodereview//compressed.huf");
        System.out.println("ѹ�����~");
    }
    @Test
    public void decodeVideo(){
        decode(".//src//huffmancodereview//compressed.huf", ".//src//huffmancodereview//decode.mp4");
        System.out.println("��ѹ���~");
    }



    // ����һ��ԭ�ļ�������ѹ�������Ŀ���ļ�
    public static void zip(String src, String dest) {
        File srcFile = new File(src);
        File destDest = new File(dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fis = new FileInputStream(srcFile);
            byte[] buffer = new byte[fis.available()];
            // ���ļ��е��������ֽ�����ȡ�� buffer ��
            fis.read(buffer);
            // ѹ�����ݵõ���Ҫ����� byte[]
            byte[] toTrans = zip(buffer);

            // �� dest �ļ���д����Ҫ����� byte[]��ͬʱ������������Թ�����
            fos = new FileOutputStream(destDest);
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

    // ��ѹ�����ļ�����
    public static void decode(String src, String dest) {
        File srcFile = new File(src);
        File destDest = new File(dest);

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFile);
            ois = new ObjectInputStream(fis);

            byte[] buffer = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            byte[] decoded = decode(buffer, huffmanCodes);

            fos = new FileOutputStream(destDest);
            fos.write(decoded);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                ois.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


















}
