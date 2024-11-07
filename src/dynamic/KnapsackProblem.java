package dynamic;

/**
 * ClassName: KnapsackProblem
 * Package: dynamic
 * Description:
 * 背包问题
 * @Author jieHFUT
 * @Create 2024/11/5 7:14
 * @Version 1.0
 */
public class KnapsackProblem {
    public static void main(String[] args) {

        // 建立一个数组，表示物品的重量
        int[] weight = {1,3,5,3,6,4,7,5};
        // 建立一个数组，表示物品的价值
        int[] value = {100, 200, 150, 300, 400, 180, 320, 260};
        // 背包的容量
        int capacity = 18;
        // 物品的个数
        int number = value.length;


        // 创建一个二维数组表示在遍历到该行零件的时候，在背包容量为该列的时候，背包能够存放物品的最大值
        int[][] maxValue = new int[number + 1][capacity + 1];
        // 为了记录在背包容量为某一个值的时候 => 放的商品的种类和个数
        int[][] path = new int[number + 1][capacity + 1];

        // 初始化第一行和第一列
        for (int i = 0; i < maxValue.length; i++) {
            maxValue[i][0] = 0;
        }
        for (int i = 0; i < maxValue[0].length; i++) {
            maxValue[0][i] = 0;
        }



        // 从第一行开始处理
        for (int i = 1; i < maxValue.length; i++) {
            for (int j = 1; j < maxValue[0].length; j++) {
                // 对每一个 maxValue 进行判断
                if (weight[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
//                    maxValue[i][j] = Math.max(maxValue[i - 1][j],
//                            maxValue[i-1][j-weight[i - 1]] + value[i - 1]);
                    int scheme1 = maxValue[i -1][j];
                    int scheme2 = maxValue[i -1][j - weight[i - 1]] + value[i - 1];
                    if (scheme1 > scheme2) {
                        // 不放新的物品
                        maxValue[i][j] = scheme1;
                    } else {
                        // 放置新的物品
                        maxValue[i][j] = scheme2;
                        path[i][j] = 1;
                    }
                }
            }

        }

        System.out.println("背包表价值表");
        int count = 1;
        System.out.println("-----1----2----3----4----5----6----7----8----9----10---11---12---13---14---15---16---17---18   ");
        for (int[] ints : maxValue) {
            for (int num : ints) {
                System.out.printf("%-5d", num);
            }
            System.out.println();
        }

        System.out.println("各个背包容量里物品的添加情况");
        for (int[] ints : path) {
            for (int num : ints) {
                System.out.printf("%-5d", num);
            }
            System.out.println();
        }
        System.out.println("背包里最终存放的物品为");
        int x = path.length - 1;
        int y = path[0].length - 1;
        while (x >= 0 && y >= 0) {
            if (path[x][y] == 1) {
                System.out.printf("第%d个物品放进背包中\n", x);
                y -= weight[x-1];
            }
            x--;
        }
    }
 }
