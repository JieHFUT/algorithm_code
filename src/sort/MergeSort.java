package sort;

import java.util.Arrays;

/**
 * ClassName: MergeSort
 * Package: sort
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/27 15:26
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        mergeSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 50)));
        System.out.println("spent " + (end - start) + " ms");
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // 分
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        // 合
        merge(arr, left, mid, right, temp);
    }
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int recodeIndexOfTemp = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[recodeIndexOfTemp++] = arr[i++];
            else
                temp[recodeIndexOfTemp++] = arr[j++];
        }
        // 已经有一边的数组到头了
        while(j <= right)
            temp[recodeIndexOfTemp++] = arr[j++];

        while (i <= mid)
            temp[recodeIndexOfTemp++] = arr[i++];

        // 两个数组对应的位置，已经在 temp 中排序完成
        int count =0;
        for (int k = left; k <= right ; k++) {
            arr[k] = temp[count++];
        }
    }
}
