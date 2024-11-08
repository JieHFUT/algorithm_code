package sort;

import java.util.Arrays;

/**
 * ClassName: QuickSort
 * Package: sort
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/27 4:40
 * @Version 1.0
 */
public class QuickSort {
    // »ù×¼
    public static void main(String[] args) {

        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 100)));
        System.out.println("spent " + (end - start) + " ms");
    }
    public static void quickSort(int[] arr, int transLeft, int transRight) {
        int left = transLeft;
        int right = transRight;
        int pivot = arr[(left +right) / 2];
        while (left < right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left >= right) break;
            swap(arr, left, right);

            if(arr[left] == pivot) {
                right--;
            }
            if (arr[right] == pivot) {
                left++;
            }
        }
        if (left == right) {
            left++;
            right--;
        }
        if (transLeft < right) quickSort(arr, transLeft, right);
        if (transRight > left) quickSort(arr, left, transRight);
    }
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
