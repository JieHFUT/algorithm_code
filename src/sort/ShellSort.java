package sort;

import java.util.Arrays;

/**
 * ClassName: ShellSort
 * Package: sort
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/27 3:56
 * @Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        shellSort2(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 100)));
        System.out.println("spent " + (end - start) + " ms");
    }
    // 交换法
    public static void shellSort(int[] arr) {
        // 分组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 前面的数字已经是有序的了
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(j, j - gap, arr);
                    }
                }
            }
        }
    }
    // 插入法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int toInsert = arr[i];
                for (j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > toInsert) {
                        arr[j + gap] = arr[j];
                    } else
                        break;
                }
                //
                arr[j + gap] = toInsert;
            }
        }
    }
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
