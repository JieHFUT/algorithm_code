package recursion;

public class MIGong {
    public static void main(String[] args) {
        // �Թ���С
        int[][] miGong = new int[8][10];
        // ���Թ����б߽��趨
        for (int i = 0; i < miGong.length; i++) {
            miGong[i][0] = 1;
            miGong[i][miGong[0].length - 1] = 1;
        }
        for (int i = 0; i < miGong[0].length; i++) {
            miGong[0][i] = 1;
            miGong[miGong.length - 1][i] = 1;
        }
        // һЩ�ϰ�
        miGong[2][0] = 1;
        miGong[2][1] = 1;
        miGong[2][2] = 1;
        miGong[6][3] = 1;
        miGong[7][3] = 1;
        // ��ʾ�Թ�
        System.out.println("��ʾ�Թ���");
        for (int i = 0; i < miGong.length; i++) {
            for (int j = 0; j < miGong[0].length; j++) {
                System.out.print(miGong[i][j] + " ");
            }
            System.out.println();
        }
        // ��ʼѰ��·��
        if (findWay(1,1, miGong)){
            System.out.println("��ʾ�Թ���");
            for (int i = 0; i < miGong.length; i++) {
                for (int j = 0; j < miGong[0].length; j++) {
                    System.out.print(miGong[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    /**
     * target = miGong[miGong.length - 1][miGong[0].length - 1]
     * @param row ������
     * @param col ������
     * @param matrix ��ͼʵ��
     * @return ����ҵ��˾ͷ����棬����ͷ��ؼ�
     * Լ������ map[i][j] Ϊ 0 ��ʾ�õ�û���߹� ��Ϊ 1 ��ʾǽ  �� 2 ��ʾͨ·������ �� 3 ��ʾ�õ��Ѿ��߹��������߲�ͨ
     * �����Թ�ʱ����Ҫȷ��һ������(����) ��->��->��->�� , ����õ��߲�ͨ���ٻ���
     */
    public static boolean findWay(int row, int col, int[][] matrix) {
        // �����ߵ�Ŀ�ĵأ����� true
        if(matrix[matrix.length - 2][matrix[0].length - 2] == 2){
            return true;
        } else {
            if (matrix[row][col] == 0) {
                // ��λ��û���߹�
                matrix[row][col] = 2; // ����õ��ܹ��ߵ�ͨ
                // ���濼���� ��-��-��-�� ��
                if(findWay(row + 1, col, matrix)){
                    return true;
                } else if(findWay(row, col + 1, matrix)){
                    return true;
                } else if (findWay(row - 1, col, matrix)) {
                    return true;
                } else if (findWay(row, col - 1, matrix)) {
                    return true;
                } else {
                    // ����·���߲�ͨ
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * Ѱ�����·��
     * @param row
     * @param col
     * @param matrix
     */
    public void findMinPath(int row, int col, int[][] matrix) {
        
    }

}
