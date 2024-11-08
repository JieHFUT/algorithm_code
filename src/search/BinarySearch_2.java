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
import java.util.Iterator;
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
            arr[i] = i + 1;
        }
        long start = System.currentTimeMillis();
        int ret = binarySearch(arr, (int)(Math.random() * 100_000_000));
        long end = System.currentTimeMillis();
        System.out.println("ret=" + ret + "   " + (end - start) + "ms");

//        int[] arr = new int[]{1,2,3,4,5,6,6,6,6,6,6,7,8,9,61};
//        long start = System.currentTimeMillis();
//        List<Integer> result = binarySearchFindAll(arr, 6);
//        long end = System.currentTimeMillis();
//        Iterator iterator = result.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("spent " + (end - start) + "ms");

    }



    // 返回第一个符合要求的数字的下标
    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }
    public static int binarySearch(int[] arr, int left, int right, int target) {

        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, right, target);
        } else {
            return binarySearch(arr, left, mid - 1, target);
        }
    }














    /**
     * 返回所有的等于 target 的下标
     * 在找到 mid 的值的时候不要马上返回
     * 向 mid 索引值的左边扫描，将所有满足要求的全部加入集合，再向右边扫描
     * {1,2,3,4,5,6,6,6,6,6,6,7,8,9,61}
     *               mid
     *            6,5,7,8,9,10
     * @param arr
     * @param target
     * @return
     */
    public static List<Integer> binarySearchFindAll(int[] arr, int target) {
        return binarySearchFindAll(arr, 0, arr.length - 1, target);
    }
    public static List<Integer> binarySearchFindAll(int[] arr, int left, int right, int target) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            List<Integer> list = new ArrayList<>();
            // 向左
            int leftIndex = mid - 1;
            while (leftIndex >= 0 && arr[leftIndex] == target) {
                list.add(leftIndex);
                leftIndex--;
            }
            list.add(mid);
            // 向右
            int rightIndex = mid + 1;
            while (rightIndex < arr.length && arr[rightIndex] == target) {
                list.add(rightIndex);
                rightIndex++;
            }
            return list;
        }
        else if (arr[mid] < target)
            return binarySearchFindAll(arr, mid+1, right, target);
        else
            return binarySearchFindAll(arr, left, mid - 1, target);
    }
}
