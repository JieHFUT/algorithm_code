package search;

/**
 * ClassName: DifferAllocSearch
 * Package: search
 * Description:
 * 差值查找（按照比重分配查询）
 * @Author jieHFUT
 * @Create 2024/10/27 18:36
 * @Version 1.0
 */
public class DifferAllocSearch_3 {
    public static void main(String[] args) {
        int[] arr = new int[10_000];
        for (int i = 0; i < 10_000; i++) {
            arr[i] = i + 1;
        }
        long start = System.currentTimeMillis();
        int ret = differAllocSearch(arr, (int) (Math.random() * 10_000));
        long end = System.currentTimeMillis();
        System.out.println("Index=" + ret + "\t" + (end - start) + "ms");
    }
    public static int differAllocSearch(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }
    public static int search(int[] arr, int left, int right, int target) {
        if (left > right || target > arr[arr.length - 1] || target < arr[0])
            return -1;
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return search(arr, left, mid - 1, target);
        else
            return search(arr, mid + 1, right, target);
    }
}
