package recursion;

public class MIGong {
    public static void main(String[] args) {
        // 迷宫大小
        int[][] miGong = new int[8][10];
        // 对迷宫进行边界设定
        for (int i = 0; i < miGong.length; i++) {
            miGong[i][0] = 1;
            miGong[i][miGong[0].length - 1] = 1;
        }
        for (int i = 0; i < miGong[0].length; i++) {
            miGong[0][i] = 1;
            miGong[miGong.length - 1][i] = 1;
        }
        // 一些障碍
        miGong[2][0] = 1;
        miGong[2][1] = 1;
        miGong[2][2] = 1;
        miGong[6][3] = 1;
        miGong[7][3] = 1;
        // 显示迷宫
        System.out.println("显示迷宫：");
        for (int i = 0; i < miGong.length; i++) {
            for (int j = 0; j < miGong[0].length; j++) {
                System.out.print(miGong[i][j] + " ");
            }
            System.out.println();
        }
        // 开始寻找路径
        if (findWay(1,1, miGong)){
            System.out.println("显示迷宫：");
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
     * @param row 出发行
     * @param col 出发列
     * @param matrix 地图实况
     * @return 如果找到了就返回真，否则就返回假
     * 约定：当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
     * 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
     */
    public static boolean findWay(int row, int col, int[][] matrix) {
        // 有人走到目的地，返回 true
        if(matrix[matrix.length - 2][matrix[0].length - 2] == 2){
            return true;
        } else {
            if (matrix[row][col] == 0) {
                // 该位置没有走过
                matrix[row][col] = 2; // 假设该地能够走的通
                // 下面考虑往 下-右-上-左 走
                if(findWay(row + 1, col, matrix)){
                    return true;
                } else if(findWay(row, col + 1, matrix)){
                    return true;
                } else if (findWay(row - 1, col, matrix)) {
                    return true;
                } else if (findWay(row, col - 1, matrix)) {
                    return true;
                } else {
                    // 四条路都走不通
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 寻找最短路径
     * @param row
     * @param col
     * @param matrix
     */
    public void findMinPath(int row, int col, int[][] matrix) {
        
    }

}
