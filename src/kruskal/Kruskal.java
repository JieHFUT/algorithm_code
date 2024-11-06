package kruskal;

import java.util.Arrays;
import java.util.Comparator;

// 克鲁斯卡尔算法
public class Kruskal {
    public static void main(String[] args) {
        String[] vertexs = {"A地", "B地", "C地", "D地", "E地", "F地", "G地"};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.

        Kruskal kruskal = new Kruskal(vertexs, matrix);
        // 打印邻接矩阵
        kruskal.printMatrix();
        // 获得所有边的数组
        Link[] links = kruskal.getLinks();
        System.out.println("排序前: " + Arrays.toString(links));
        // 给所有的边进行排序
        kruskal.sortLinks(links);
        System.out.println("排序后: " + Arrays.toString(links));
        // 进行克鲁斯卡尔算法


    }







    // 边的个数
    private int edgeNums;
    // 顶点数组
    private String[] vertexs;
    // 边的权值矩阵
    private int[][] matrix;
    // 边不能连通
    private static final int INF = 65535;

    // 在构造方法中对传入的数据进行赋值
    public Kruskal(String[] vertexs, int[][] matrix) {
        int number = vertexs.length;

        // 构建顶点数组
        this.vertexs = new String[number];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        // 构建邻接矩阵
        this.matrix = new int[number][number];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        // 统计边的个数
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != INF) {
                    this.edgeNums++;
                }
            }
        }
    }
    //////////////////   上面是构造方法    /////////////////////////////

    // 打印邻接矩阵
    public void printMatrix() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                System.out.printf("%-7d", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    // 通过 matrix 获得所有的边
    public Link[] getLinks() {
        Link[] links = new Link[this.edgeNums];
        int index = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = i + 1; j < this.matrix[0].length; j++) {
                if (this.matrix[i][j] != INF) {
                    links[index++] = new Link(vertexs[i], vertexs[j], this.matrix[i][j]);
                }
            }
        }
        return links;
    }

    // 对所有的边进行排序
    public void sortLinks(Link[] links) {
        Arrays.sort(links);
    }
    // 第二种排序方法
    public void sortEdges(Link[] links) {
        Arrays.sort(links, new Comparator<Link>() {
            @Override
            public int compare(Link o1, Link o2) {
                return o1.weight - o2.weight;
            }
        });
    }

    // 开始进行克鲁斯卡尔算法
    public void kruskal() {

    }




}

