package sparsearray;

/**
 * ClassName: SparseArray
 * Package: sparsearray
 * Description:
 * 练习稀疏数组
 * @Author jieHFUT
 * @Create 2024/10/16 23:54
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组
        // 0: 表示没有棋子  1：表示黑子  2：表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 2;

        // 输出原始的二维数组
        System.out.println("原始的二维数组：");
        for(int[] arr : chessArr1) {
            for(int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        // 将二维数组转稀疏数组
        // 1. 先遍历二维数组，获取数组中棋子的个数，得到稀疏数组的大小
        int chessNumber = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    chessNumber++;
                }
            }
        }

        // 创建稀疏数组并且给稀疏数组首行赋值
        int[][] sparseArr = new int[chessNumber + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = chessNumber;

        // 遍历二维数组，将非 0 的值存放在稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                // 第 i 行，第 j 列，数值为 chessARR1[i][j], 放在第稀疏数组 count + 1 行
                if (chessArr1[i][j] != 0) {
                    //
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组: ");
        for(int[] arr : sparseArr) {
            for(int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        // 稀疏数组恢复成原始的二维数组
        // 1. 先读取稀疏数组的第一行，先创建处原始数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2. 读取稀疏数组第二行开始的数组给原始数组赋值
        for (int i = 1; i < sparseArr.length; i++) {
            // 第二行开始
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 输出原始数组：
        System.out.println("输出稀疏数组导出的原始数组：");
        for(int[] arr : chessArr2) {
            for(int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

    }
}
