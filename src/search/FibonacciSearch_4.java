package search;

import java.util.Arrays;

/**
 * ClassName: FibonacciSearch_4
 * Package: search
 * Description:
 * 쳲���������
 * @Author jieHFUT
 * @Create 2024/10/27 19:13
 * @Version 1.0
 */
public class FibonacciSearch_4 {
    public static void main(String[] args) {
        // ��Ҫһ�����������
        int[] arr = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            arr[i] = i + 1;
        }
        long start = System.currentTimeMillis();
        int ret = fibonacciSearch(arr, (int)(Math.random() * 100_000));
        long end = System.currentTimeMillis();
        System.out.println("ret=" + ret + "   " + (end - start) + "ms");
    }
    public static int maxSize = 1000;
    // ����쳲���������
    public static int[] fib() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
    // 1 1 2 3 5 8 11 19 30 49 79 ...       79 = 30 + 49 => 79 - 1 = (30 - 1) + (49 - 1) + 1
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 ... 79...
    public static int fibonacciSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        // �� arr �ճ� fib ����
        int k = 0;
        int[] f = fib();
        while (high > f[k] - 1)
            k++;
        // �ҵ��������鳤�ȵĲ�����ӽ��䳤�ȵ�쳲�������
        int[] fib = Arrays.copyOf(arr, f[k] - 1);
        for (int i = arr.length; i < fib.length; i++) {
            fib[i] = arr[arr.length - 1];
        }
        while (low <= high) {
            int mid = low + f[k-1] - 1;
            if (target < fib[mid]) {
                // ��߱���
                high = mid - 1;
                k--;
            } else if (target > fib[mid]) {
                // �ұ߱���
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high)
                    return mid;
                return high;
            }
        }
        return -1;
    }
}
