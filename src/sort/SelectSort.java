package sort;

import java.util.Arrays;

/**
 * ClassName: SelectSort
 * Package: sort
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/27 3:22
 * @Version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 100)));
        System.out.println("spent " + (end - start) + " ms");
    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, arr);
        }
    }
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
