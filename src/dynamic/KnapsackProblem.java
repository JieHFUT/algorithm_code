package dynamic;

/**
 * ClassName: KnapsackProblem
 * Package: dynamic
 * Description:
 * ��������
 * @Author jieHFUT
 * @Create 2024/11/5 7:14
 * @Version 1.0
 */
public class KnapsackProblem {
    public static void main(String[] args) {

        // ����һ�����飬��ʾ��Ʒ������
        int[] weight = {1,3,5,3,6,4,7,5};
        // ����һ�����飬��ʾ��Ʒ�ļ�ֵ
        int[] value = {100, 200, 150, 300, 400, 180, 320, 260};
        // ����������
        int capacity = 18;
        // ��Ʒ�ĸ���
        int number = value.length;


        // ����һ����ά�����ʾ�ڱ��������������ʱ���ڱ�������Ϊ���е�ʱ�򣬱����ܹ������Ʒ�����ֵ
        int[][] maxValue = new int[number + 1][capacity + 1];
        // Ϊ�˼�¼�ڱ�������Ϊĳһ��ֵ��ʱ�� => �ŵ���Ʒ������͸���
        int[][] path = new int[number + 1][capacity + 1];

        // ��ʼ����һ�к͵�һ��
        for (int i = 0; i < maxValue.length; i++) {
            maxValue[i][0] = 0;
        }
        for (int i = 0; i < maxValue[0].length; i++) {
            maxValue[0][i] = 0;
        }



        // �ӵ�һ�п�ʼ����
        for (int i = 1; i < maxValue.length; i++) {
            for (int j = 1; j < maxValue[0].length; j++) {
                // ��ÿһ�� maxValue �����ж�
                if (weight[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
//                    maxValue[i][j] = Math.max(maxValue[i - 1][j],
//                            maxValue[i-1][j-weight[i - 1]] + value[i - 1]);
                    int scheme1 = maxValue[i -1][j];
                    int scheme2 = maxValue[i -1][j - weight[i - 1]] + value[i - 1];
                    if (scheme1 > scheme2) {
                        // �����µ���Ʒ
                        maxValue[i][j] = scheme1;
                    } else {
                        // �����µ���Ʒ
                        maxValue[i][j] = scheme2;
                        path[i][j] = 1;
                    }
                }
            }

        }

        System.out.println("�������ֵ��");
        int count = 1;
        System.out.println("-----1----2----3----4----5----6----7----8----9----10---11---12---13---14---15---16---17---18   ");
        for (int[] ints : maxValue) {
            for (int num : ints) {
                System.out.printf("%-5d", num);
            }
            System.out.println();
        }

        System.out.println("����������������Ʒ��������");
        for (int[] ints : path) {
            for (int num : ints) {
                System.out.printf("%-5d", num);
            }
            System.out.println();
        }
        System.out.println("���������մ�ŵ���ƷΪ");
        int x = path.length - 1;
        int y = path[0].length - 1;
        while (x >= 0 && y >= 0) {
            if (path[x][y] == 1) {
                System.out.printf("��%d����Ʒ�Ž�������\n", x);
                y -= weight[x-1];
            }
            x--;
        }
    }
 }
