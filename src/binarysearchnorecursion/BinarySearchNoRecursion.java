package binarysearchnorecursion;

/**
 * 二分查找，但是不使用递归
 */
public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,13,24,35,44,67,132};
        System.out.println("target 的下标是：" + binarySearchNoRecursion(arr, 44));
    }


    public static int binarySearchNoRecursion(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
