package sort;

import java.util.Arrays;

/**
 * ClassName: Radix
 * Package: sort
 * Description:
 * 桶排序 也叫基数排序 23ms
 * @Author jieHFUT
 * @Create 2024/10/24 23:22
 * @Version 1.0
 */
public class RadixSort_7 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("spent: " + (end - start) + "ms");
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {

        int[][] bucket = new int[10][arr.length];
        int[] bucketIndexNumber = new int[bucket.length];

        // 计算该数组的最大数字的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int enlarged = 1;
        int maxNum = (max + "").length();
        for (int k = 0; k < maxNum; k++, enlarged *= 10) {
            // 依次排序个位、十位、百位
            // 个、十、百... 位数的数字
            for (int i = 0; i < arr.length; i++) {
                // 获得该数组的第 i 个元素的个位数
                int digit = (arr[i] / enlarged) % 10;
                // 将该数字放进对应的桶中
                bucket[digit][bucketIndexNumber[digit]] = arr[i];
                bucketIndexNumber[digit]++;
            }
            // 此时数组中的数字已经全部入桶，将桶中的数字全部拿出放回数组中
            int recodeArr = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketIndexNumber[i] > 0) {
                    // 说明第 i 个桶中有数据
                    for (int j = 0; j < bucketIndexNumber[i]; j++) {
                        // 从下标为 0 的位置拿数据，拿 bucketIndexNumber[i] 个
                        arr[recodeArr++] = bucket[i][j];
                    }
                }
                bucketIndexNumber[i] = 0;
            }
        }


    }
}
