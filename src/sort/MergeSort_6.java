package sort;

import java.util.Arrays;

// 归并排序 wrong
public class MergeSort_6 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(arr));
    }






    // 分
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);

    }
    // 归并排序的合并方法
    public static void merge(int[] arr, int left, int mid, int right, int[] ret) {
        /**
         * [2,6,3,4,7,2,6,9]
         *  2 6   3 4
         *  2 3 4 6
         * 所以只需要拷贝 left 到 right 的内容就可以了
         */
        int i = left;
        int count = 0;
        int j = mid + 1;
        // 可以考虑现在是两个有序数组 一个是arr[0 => mid] 一个是arr[mid+1 => right]
        while(i <= mid && j <= right) {
            // 两个有序数组都还没有到头
            if(arr[i] < arr[j]) {
                // 将较小的加入到零时数组中
                ret[count] = arr[i];
                count++;
                i++;
            } else {
                ret[count] = arr[j];
                count++;
                j++;
            }
        }
        // 已经有某一个数组到头了
        if(i == mid) {
            while(j <= right) {
                ret[count] = arr[j];
                count++;
                j++;
            }
        }
        if(j == right) {
            while(i <= mid) {
                ret[count] = arr[i];
                count++;
                i++;
            }
        }
        // 已经将 arr 中数据在 ret 中有序放置，并不是每次都拷贝 8 个
        count = 0;
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = ret[count];
            count++;
            tempLeft++;
        }
    }
}
