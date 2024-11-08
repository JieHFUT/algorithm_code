package sparsearray;

/**
 * ClassName: SparseArray
 * Package: sparsearray
 * Description:
 * ��ϰϡ������
 * @Author jieHFUT
 * @Create 2024/10/16 23:54
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        // ����һ��ԭʼ�Ķ�ά����
        // 0: ��ʾû������  1����ʾ����  2����ʾ����
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 2;

        // ���ԭʼ�Ķ�ά����
        System.out.println("ԭʼ�Ķ�ά���飺");
        for(int[] arr : chessArr1) {
            for(int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        // ����ά����תϡ������
        // 1. �ȱ�����ά���飬��ȡ���������ӵĸ������õ�ϡ������Ĵ�С
        int chessNumber = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    chessNumber++;
                }
            }
        }

        // ����ϡ�����鲢�Ҹ�ϡ���������и�ֵ
        int[][] sparseArr = new int[chessNumber + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = chessNumber;

        // ������ά���飬���� 0 ��ֵ�����ϡ��������
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                // �� i �У��� j �У���ֵΪ chessARR1[i][j], ���ڵ�ϡ������ count + 1 ��
                if (chessArr1[i][j] != 0) {
                    //
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //���ϡ������
        System.out.println("ϡ������: ");
        for(int[] arr : sparseArr) {
            for(int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        // ϡ������ָ���ԭʼ�Ķ�ά����
        // 1. �ȶ�ȡϡ������ĵ�һ�У��ȴ�����ԭʼ����
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2. ��ȡϡ������ڶ��п�ʼ�������ԭʼ���鸳ֵ
        for (int i = 1; i < sparseArr.length; i++) {
            // �ڶ��п�ʼ
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // ���ԭʼ���飺
        System.out.println("���ϡ�����鵼����ԭʼ���飺");
        for(int[] arr : chessArr2) {
            for(int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

    }
}
