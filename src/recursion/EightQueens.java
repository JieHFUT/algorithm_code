package recursion;

/**
 * 八皇后问题 回溯
 *
 *
 */
public class EightQueens {

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.putQueens(1);
        System.out.printf("一共有 %d 种解法", queens.count);
    }

    int count = 0;
    int queenNum = 8; // 代表皇后的数量
    int[] queens = new int[queenNum]; // 用于存储皇后的位置

    // 打印皇后的位置
    private void printQueens(int[] queens) {
        count++;
        for (int i = 0; i < queenNum; i++) {
            System.out.print(queens[i] + " ");
        }
        System.out.println();
    }

    // 判断第 n 行的皇后是不是和前面的 n-1 个皇后的位置冲突
    private boolean judgeConflict(int n) {
        for (int i = 0; i < n - 1; i++) {
            // 和前面 n-1 行皇后的位置进行对比
            if(queens[i] == queens[n - 1] || Math.abs(n - i - 1) == Math.abs(queens[n - 1] - queens[i])) {
                // 说明这个皇后和之前的在同一行或者对角
                return false;
            }
        }
        return true;
    }

    // 放置第 n 个皇后
    private void putQueens(int n) {
        if (n == queenNum + 1) {
            printQueens(queens);
            return;
        }
        for (int i = 0; i < queenNum; i++) {
            // 先将该皇后放在第一个位置上，然后检测其是否冲突
            queens[n - 1] = i;
            if (judgeConflict(n)) {
                // 不冲突的话，就放置第 n+1 个皇后
                putQueens(n + 1);
            }
            // 冲突的话，就将第 n 个皇后向后挪一位直到其不冲突为止
        }
    }



}
