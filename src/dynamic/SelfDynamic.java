package dynamic;

/**
 * 通过 价值/重量 表示某一件物品的权值，优先选择物品权值较大的
 */

public class SelfDynamic {
    public static void main(String[] args) {

        // 建立一个数组，表示物品的重量
        int[] weight = {1,3,5,3,6,4,7,5};
        // 建立一个数组，表示物品的价值
        int[] value = {100, 200, 150, 300, 400, 180, 320, 260};
        // 背包的容量
        int capacity = 18;
        // 物品的个数
        int number = value.length;

//        Map<Integer, Integer> data = new HashMap();
//        for (int i = 0; i < number; i++) {
//            data.put(weight[i], value[i]);
//        }
//        Map<Double, Integer> toChoice = new HashMap();
//        for (int i = 0; i < number; i++) {
//            toChoice.put((double)value[i] / (double)weight[i], weight[i]);
//        }

        double[] toChoice = new double[number];
        for (int i = 0; i < number; i++) {
            toChoice[i] = (double) value[i] / (double) weight[i];
        }




    }
}
