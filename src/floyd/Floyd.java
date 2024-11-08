package floyd;

import org.junit.Test;

import static floyd.Graph.N;

/**
 * ClassName: Floyd
 * Package: floyd
 * Description:
 * ���������㷨������������㵽�����������̾���
 * @Author jieHFUT
 * @Create 2024/11/7 22:02
 * @Version 1.0
 */
public class Floyd {

    public static void main(String[] args) {

        // ͼ�Ķ���
        String[] vertexs = {"A��", "B��", "C��", "D��", "E��", "F��", "G��"};
        // Ȩֵ��
        int[][] weights = new int[vertexs.length][vertexs.length];
        weights[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        weights[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        weights[2] = new int[] { 7, N, 0, N, 8, N, N };
        weights[3] = new int[] { N, 9, N, 0, N, 4, N };
        weights[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        weights[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        weights[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        // ����ͼ
        Graph graph = new Graph(vertexs.length, vertexs, weights);
        // ����Щ���ݽ��и��������㷨
        long start = System.currentTimeMillis();
        graph.floyd();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    @Test
    public void test(){
        // ͼ�Ķ���
        String[] vertexs = {"A��", "B��", "C��", "D��", "E��", "F��"};
        // Ȩֵ��
        int[][] weights = new int[vertexs.length][vertexs.length];
        weights[0] = new int[] { 0, 2, N, 4, N, N };
        weights[1] = new int[] { 2, 0, 5, N, N, N };
        weights[2] = new int[] { N, 5, 0, N, 1, N };
        weights[3] = new int[] { 4, N, N, 0, 3, N };
        weights[4] = new int[] { N, N, 1, 3, 0, 2 };
        weights[5] = new int[] { N, N, N, N, 2, 0 };
        //
        Graph graph = new Graph(vertexs.length, vertexs, weights);
        graph.floyd();
    }


    @Test
    public void test1(){
        // ͼ�Ķ���
        String[] vertexs = {"A��", "B��", "C��", "D��", "E��", "F��", "G��", "H��", "I��", "J��"};
        // Ȩֵ��
        int[][] weights = new int[vertexs.length][vertexs.length];
        weights[0] =  new int[] { 0, 5, 7, N, N, N, 2, N, N, N };
        weights[1] =  new int[] { 5, 0, N, 9, N, N, 3, N, N, N };
        weights[2] =  new int[] { 7, N, 0, N, 8, N, N, N, N, 6  };
        weights[3] =  new int[] { N, 9, N, 0, N, 4, N, 3, N, N  };
        weights[4] =  new int[] { N, N, 8, N, 0, 5, 4, N, 5, N  };
        weights[5] =  new int[] { N, N, N, 4, 5, 0, 6, N, N, N  };
        weights[6] =  new int[] { 2, 3, N, N, 4, 6, 0, N, N, 4  };
        weights[7] =  new int[] { N, N, N, 3, N, N, N, 0, N, N  };
        weights[8] =  new int[] { N, N, N, N, 5, N, N, N, 0, 2  };
        weights[9] =  new int[] { N, N, 6, N, N, N, 4, N, 2, 0  };



        // ����ͼ
        Graph graph = new Graph(vertexs.length, vertexs, weights);
        // ����Щ���ݽ��и��������㷨
        long start = System.currentTimeMillis();
        graph.floyd();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }


}
