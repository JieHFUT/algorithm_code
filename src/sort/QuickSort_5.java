package sort;

import java.util.Arrays;

// 快速排序
public class QuickSort_5 {
    public static void main(String[] args) {
//        int[] arr = new int[]{23,4,6,76,546,45,43,4,35,45,45,65,7,65,34,123,8};
//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int leftKey, int rightKey) {
        int left = leftKey;
        int right = rightKey;
        // 选取一个基准，比它大的放在右边，比他小的放在左边 (现在以中间的元素为基准测试: 中轴 pivot)
        int pivot = (right + left) / 2;
        int toCompare = arr[pivot];
        while (left < right) {
            while (arr[left] < toCompare) {
                left++;
            }
            while (arr[right] > toCompare) {
                right--;
            }
            if (left >= right) {
                // 此轮排序已结束
                break;
            }
            // 到这个地方，arr[left] >= arr[right]  => 交换
            swap(arr, left, right);

            if(arr[left] == toCompare)
                right--;
            if (arr[right] == toCompare)
                left++;
        }
        if(left == right) {
            left++;
            right--;
        }
        // 对左边比基准小的再次排序
        if (leftKey < right)
            quickSort(arr, leftKey, right);
        // 对右边比基准大的再次排序
        if (left < rightKey)
            quickSort(arr, left, rightKey);
    }
    // 交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
