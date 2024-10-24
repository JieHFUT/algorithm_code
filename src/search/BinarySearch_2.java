package search;

/**
 * ClassName: BinarySearch_2
 * Package: search
 * Description:
 * 二分查找
 * @Author jieHFUT
 * @Create 2024/10/25 2:24
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 如果 mid 就是我们要找的目标，返回 mid
 * 如果 mid 处值小于 target, 就像右边遍历
 * 如果 mid 处值大于 target, 就像左边遍历
 * 如果遍历完还没有找到就返回 -1
 */
public class BinarySearch_2 {
    public static void main(String[] args) {
        // 需要一个有序的数组
        int[] arr = new int[100_000_000];
        for (int i = 0; i < 100_000_000; i++) {
            arr[i] = i;
        }
        long start = System.currentTimeMillis();
        int ret = binarySearch(arr, 0, arr.length - 1, (int) (Math.random() * 100_000_000));
        long end = System.currentTimeMillis();
        System.out.println("ret=" + ret + "   " + (end - start) + "ms");

    }

    // 返回第一个符合要求的数字的下标
    public static int binarySearch(int[] arr, int left, int right, int target) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, right, target);
        } else {
            return binarySearch(arr, left, mid - 1, target);
        }
    }

    // 返回所有的符合要求的数字的下标
//    public static List<Integer> binarySearch1(int[] arr, int left, int right, int target) {
//
//        if (left > right) {
//            return -1;
//        }
//        int mid = (left + right) / 2;
//        if (arr[mid] == target) {
//            //
//            List<Integer> list = new ArrayList<>();
//
//            return mid;
//        } else if (arr[mid] < target) {
//            return binarySearch(arr, mid + 1, right, target);
//        } else {
//            return binarySearch(arr, left, mid - 1, target);
//        }
//    }
}
