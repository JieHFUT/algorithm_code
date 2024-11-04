package huffmancodereview;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        // 压缩 => 解压
        String content =
                "于是分布式版本控制系统（Distributed Version Control System，简称 DVCS）面世了。 在这类系统中，像\n" +
                "于是分布式版本控制系统（Distributed Version Control System，简称 DVCS）面世了。 在这类系统中，像\n" +
                "Git、Mercurial 以及 Darcs 等，客户端并不只提取最新版本的文件快照， 而是把代码仓库完整地镜像下来，包\n" +
                "Git、Mercurial 以及 Darcs 等，客户端并不只提取最新版本的文件快照， 而是把代码仓库完整地镜像下来，包\n" +
                "括完整的历史记录。 这么一来，任何一处协同工作用的服务器发生故障，事后都可以用任何一个镜像出来的本\n" +
                "括完整的历史记录。 这么一来，任何一处协同工作用的服务器发生故障，事后都可以用任何一个镜像出来的本\n" +
                "于是分布式版本控制系统（Distributed Version Control System，简称 DVCS）面世了。 在这类系统中，像\n" +
                "于是分布式版本控制系统（Distributed Version Control System，简称 DVCS）面世了。 在这类系统中，像\n" +
                "Git、Mercurial 以及 Darcs 等，客户端并不只提取最新版本的文件快照， 而是把代码仓库完整地镜像下来，包\n" +
                "Git、Mercurial 以及 Darcs 等，客户端并不只提取最新版本的文件快照， 而是把代码仓库完整地镜像下来，包\n" +
                "括完整的历史记录。 这么一来，任何一处协同工作用的服务器发生故障，事后都可以用任何一个镜像出来的本\n" +
                "括完整的历史记录。 这么一来，任何一处协同工作用的服务器发生故障，事后都可以用任何一个镜像出来的本\n" +
                "地仓库恢复。 因为每一次的克隆操作，实际上都是一次对代码仓库的完整备份。";

        byte[] input = content.getBytes();
        System.out.println("输入得到的字节数组为：");
        System.out.println(Arrays.toString(input));

        List<Node> nodes = statistics(input);
        System.out.println("统计的各个字符出现的数字为：");
        for (Node node : nodes)
            System.out.println(node);

        Node root = createHuffmanTree(nodes);
        System.out.println("构造的哈夫曼树为：");
        root.preOrder();

        System.out.println("得到的哈夫曼编码为：");
        Map<Byte, String> huffmanCodes = getHuffmanCodes(root);
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("编码后得到的待重整传输的0101001流为：");

        // zip 就是压缩后的 01 代码转化为待传输的字节数组
        System.out.println("01010... 转换的待发送的字节数组为：");
        byte[] zip = compress(input, huffmanCodes);
        System.out.println(Arrays.toString(zip));

        System.out.println("压缩率为：" + input.length + " " + zip.length);

        // 解压
        System.out.println("解压后得到的0101001010...编码为：");

        System.out.println("解压后得到的010010100...匹配得到的byte数组是：");
        byte[] decodeBytes = decode(zip);
        System.out.println(Arrays.toString(decodeBytes));
        // byte[] 转 string
        String result = new String(decodeBytes);
        System.out.println(result);
    }


    // 将压缩文件的过程整合
    public static byte[] zip(byte[] input) {
        // 统计各个字符出现的次数
        List<Node> nodeList = statistics(input);
        // 构建哈夫曼树
        Node root = createHuffmanTree(nodeList);
        // 构建哈夫曼表
        Map<Byte, String> huffmanCodes = getHuffmanCodes(root);
        // 获得压缩后需要传输的 byte[]
        byte[] zipBytes = compress(input, huffmanCodes);
        // 返回
        return zipBytes;
    }




    // 根据传入的 byte[] 统计各个字符出现的次数，以 Node [value, weight] 集合形式输出
    public static List<Node> statistics(byte[] input) {
        Map<Byte, Integer> map = new HashMap<>();
        for (Byte b : input) {
            Integer weight = map.get(b);
            if (weight == null) {
                // 说明哈希表中还没有添加过这种字符
                map.put(b, 1);
            } else {
                // 说明哈希表中已经添加过这种字符
                map.put(b, weight + 1);
            }
        }
        // 将哈希表中 key 不为 null 的元素加入集合中
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                nodes.add(new Node(entry.getKey(), entry.getValue()));
            }
        }
        return nodes;
    }

    // 以得到的 List<Node> 中 weight 构建 huffmanTree
    public static Node createHuffmanTree(List<Node> nodes) {
        // 每次选出 weight 最小的两个构树
        while (nodes.size() > 1) {
            // 将这个集合根据 weight 进行排序
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null, left.weight + right.weight);
            // 取出最小的两个再将合成的放进去重新排序
            parent.left = left;
            parent.right = right;


            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        // 剩下的就是构建 哈夫曼树 的根节点
        return nodes.get(0);
    }


    // 根据构建的哈夫曼树构建哈夫曼编码表
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 构建哈夫曼编码表
     * @param root 哈夫曼树的根节点
     * @param code 每次往下走一层一个字符添加的 “0” 或者 “1”
     * @param stringBuilder 用来记录从根节点到某一个叶子的 0101001 代码
     * @return
     */
    public static void getHuffmanCodes(Node root, String code, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder(stringBuilder);

        sb.append(code);
        if (root.value == null) {
            // 说明这层的这个节点不是叶子节点
            if (root.left != null)
                getHuffmanCodes(root.left, "0", sb);
            if (root.right != null)
                getHuffmanCodes(root.right, "1", sb);
        } else {
            // 说明这层的这个节点是叶子节点, 将该节点字符 和 路径编码放到map中
            huffmanCodes.put(root.value, sb.toString());
        }
    }

    // 简化传入的变量
    public static Map<Byte, String> getHuffmanCodes(Node root) {
        if (root == null) return null;
        getHuffmanCodes(root, "", stringBuilder);
        return huffmanCodes;
    }

    // 将由需要压缩的资源转换成的 byte[] 根据哈夫曼编码 huffmanCodes 压缩成 01010010100101010 代码
    // 再将 010100100101010 转化为 byte[] 存储，然后通过网络发送
    public static byte[] compress(byte[] input) {
        return compress(input, huffmanCodes);
    }
    // 压缩
    public static byte[] compress(byte[] input, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte b : input) {
            String code = huffmanCodes.get(b);
            stringBuilder.append(code);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////// 这是待传送的0101001001...流
        //////////////////////////////////////////////////////////////////////////////////////////////////
        //System.out.println(stringBuilder.toString());
        // 将 010101001010010010000101001010... 转化为 byte[]
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
        // 编码得到的：000010111001100110011111001011011101011011100
        // 解码得到的：000010111001100110011111001011011101011011100
    }


    // 解码，根据传入的经过编码的 byte[]，将其内信息转化为 010100101...
    // 再根据 01 代码匹配哈夫曼表将其解码为原本的 byte[]
    public static byte[] decode(byte[] zip) {
        return decode(zip, huffmanCodes);
    }
    public static byte[] decode(byte[] zip, Map<Byte, String> huffmanCodes) {
        // 转化为 01010100...
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zip.length; i++) {
            if (i == zip.length - 1) {
                // 最后一个可能不足 8 位
                str = byteToString(true, zip[i]);
            } else {
                str = byteToString(false, zip[i]);
            }
            stringBuilder.append(str);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////// 这是待传送的0101001001...流
        //////////////////////////////////////////////////////////////////////////////////////////////////
        //System.out.println(stringBuilder.toString());
        // 此时重新获得 0100101010111010101001010100101001010100100100001010101100010010100...
        // 将这一串 01 代码和哈夫曼表匹配，匹配到的结果放在集合里
        List<Byte> decodeResult = new ArrayList<>();
        Map<String, Byte> toSearchHuffmanCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet())
            toSearchHuffmanCodes.put(entry.getValue(), entry.getKey());

        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                // 匹配到了就结束循环
                String toSearch = stringBuilder.substring(i, i + count);
                if (toSearchHuffmanCodes.get(toSearch) == null) {
                    // 没有匹配到
                    count++;
                } else {
                    // 匹配到了
                    flag = false;
                    decodeResult.add(toSearchHuffmanCodes.get(toSearch));
                }
            }
            i = i + count;
        }
        // 已经把解码的 byte[] 放在集合中
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
            // 可能不足 8 位
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
        // 10101101 补码：10101101  反码:10101100  原码:11010011     原码=> -83
        System.out.println((byte) Integer.parseInt("10101101", 2)); // -83
        System.out.println((byte) Integer.parseInt("101010011", 2)); // 83
        System.out.println((byte) Integer.parseInt("110101101", 2)); // -83
    }


















    @Test
    public void zip(){
        zip(".//src//huffmancodereview//sun.bmp", ".//src//huffmancodereview//compress.huf");
        System.out.println("压缩完成~");
    }
    @Test
    public void decode(){
        decode(".//src//huffmancodereview//compress.huf", ".//src//huffmancodereview//decode.bmp");
        System.out.println("解压完成~");
    }

    @Test
    public void zipVideo(){
        zip(".//src//huffmancodereview//tocompress.mp4", ".//src//huffmancodereview//compressed.huf");
        System.out.println("压缩完成~");
    }
    @Test
    public void decodeVideo(){
        decode(".//src//huffmancodereview//compressed.huf", ".//src//huffmancodereview//decode.mp4");
        System.out.println("解压完成~");
    }



    // 传入一个原文件，将起压缩输出到目标文件
    public static void zip(String src, String dest) {
        File srcFile = new File(src);
        File destDest = new File(dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fis = new FileInputStream(srcFile);
            byte[] buffer = new byte[fis.available()];
            // 将文件中的内容以字节流读取到 buffer 中
            fis.read(buffer);
            // 压缩数据得到需要传输的 byte[]
            byte[] toTrans = zip(buffer);

            // 向 dest 文件中写入需要传输的 byte[]，同时传入哈夫曼表以供解码
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

    // 将压缩的文件解码
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
