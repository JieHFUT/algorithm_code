package sort;

import java.util.Arrays;

/**
 * ClassName: BubbleSort
 * Package: sort
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/27 3:08
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 100)));
        System.out.println("spent " + (end - start) + " ms");
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length- 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }
    public static void bubbleSort2(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j, j + 1, arr);
                    flag = false;
                }
            }
            if (flag)
                break;
            flag = true;
        }
    }
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
