package search;

/**
 * ClassName: SeqSearch_1
 * Package: search
 * Description:
 * 顺序查找: 找到一个满足条件的值就返回 (返回该值的下标)         20ms
 * @Author jieHFUT
 * @Create 2024/10/25 2:15
 * @Version 1.0
 */
public class SeqSearch_1 {
    public static void main(String[] args) {
        int[] arr = new int[100_000_000];
        for (int i = 0; i < 100_000_000; i++) {
            arr[i] = (int) (Math.random() * 100_000_000);
        }
        long start = System.currentTimeMillis();
        int ret = seqSearch(arr, 99);
        long end = System.currentTimeMillis();
        System.out.println("ret=" + ret + "   " + (end - start) + "ms");
    }

    public static int seqSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
