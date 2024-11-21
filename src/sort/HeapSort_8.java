package sort;

import java.util.Arrays;

/**
 * ClassName: HeapSort_8
 * Package: sort
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/30 20:58
 * @Version 1.0
 */
public class HeapSort_8 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 100)));
        System.out.println("spent " + (end - start) + " ms");

    }
    // 非叶子节点
    public static void heapSort(int[] arr) {
        // 变成了一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjust(arr, i, arr.length);
        }
        // 交换
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }

    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 调整 tree, 从左至右，从下往上
    public static void adjust(int[] arr, int i, int length) {
        // i 为要排序的树根，其左右子树已经排序完毕
        // 谁和根交换，谁就要重排
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
