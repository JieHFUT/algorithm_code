package recursion;

/**
 * �˻ʺ����� ����
 *
 *
 */
public class EightQueens {

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.putQueens(1);
        System.out.printf("һ���� %d �ֽⷨ", queens.count);
    }

    int count = 0;
    int queenNum = 8; // ����ʺ������
    int[] queens = new int[queenNum]; // ���ڴ洢�ʺ��λ��

    // ��ӡ�ʺ��λ��
    private void printQueens(int[] queens) {
        count++;
        for (int i = 0; i < queenNum; i++) {
            System.out.print(queens[i] + " ");
        }
        System.out.println();
    }

    // �жϵ� n �еĻʺ��ǲ��Ǻ�ǰ��� n-1 ���ʺ��λ�ó�ͻ
    private boolean judgeConflict(int n) {
        for (int i = 0; i < n - 1; i++) {
            // ��ǰ�� n-1 �лʺ��λ�ý��жԱ�
            if(queens[i] == queens[n - 1] || Math.abs(n - i - 1) == Math.abs(queens[n - 1] - queens[i])) {
                // ˵������ʺ��֮ǰ����ͬһ�л��߶Խ�
                return false;
            }
        }
        return true;
    }

    // ���õ� n ���ʺ�
    private void putQueens(int n) {
        if (n == queenNum + 1) {
            printQueens(queens);
            return;
        }
        for (int i = 0; i < queenNum; i++) {
            // �Ƚ��ûʺ���ڵ�һ��λ���ϣ�Ȼ�������Ƿ��ͻ
            queens[n - 1] = i;
            if (judgeConflict(n)) {
                // ����ͻ�Ļ����ͷ��õ� n+1 ���ʺ�
                putQueens(n + 1);
            }
            // ��ͻ�Ļ����ͽ��� n ���ʺ����Ųһλֱ���䲻��ͻΪֹ
        }
    }



}
