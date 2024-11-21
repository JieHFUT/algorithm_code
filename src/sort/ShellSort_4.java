package sort;

import java.util.Arrays;

// 希尔排序 => 也被称为缩小增量排序 => 是插入排序的改进版
// 希尔排序(交换式) => 10万个数据: spent time: 7234 ms
// 希尔排序(插入式) => 10万个数据: spent time: 23 ms
public class ShellSort_4 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        // System.out.println(Arrays.toString(arr));

    }
    // 希尔排序 => 交换法
    public static void shellSort(int[] arr) {
        // 先将数组分为 arr.length / 2 组
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            count++;
            // 先是两个前后元素对比，小的放置在前面 => 交换式
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        // 交换这两个元素
                        swap(arr, j, j + gap);
                    }
                }
            }
            // System.out.println("第" + count + "轮的结果是: " + Arrays.toString(arr));
        }
    }
    // 希尔排序 => 移位法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int toInsert = arr[i];
                for (j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > toInsert) {
                        // 大于要插入值的数据后移
                        arr[j + gap] = arr[j];
                    } else {
                        // 找到插入点
                        arr[j + gap] = toInsert;
                        break;
                    }
                }
                if(j < 0) {
                    arr[j + gap] = toInsert;
                }
            }
        }
    }
    // 交换两个元素
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
