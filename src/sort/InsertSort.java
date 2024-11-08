package sort;

import java.util.Arrays;

/**
 * ClassName: InsertSort
 * Package: sort
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/27 3:33
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 100)));
        System.out.println("spent " + (end - start) + " ms");
    }
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = 0;
            int toInsert = arr[i + 1];
            // ��ǰ��� i ��Ԫ�ؽ��бȽ�
            for (j = i; j >= 0; j--) {
                if (arr[j] > toInsert) {
                    // ����
                    arr[j + 1] = arr[j];
                } else {
                    // �ҵ�λ��
                    break;
                }
            }
            // break 1. �ҵ�λ��
            //       2. ǰ���ȫ������ toInsert �󣬴�ʱ j = -1
            arr[j + 1] = toInsert;
        }
    }

}
