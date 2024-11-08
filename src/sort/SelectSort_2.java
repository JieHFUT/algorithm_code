package sort;

import java.util.Arrays;

/**
 * ClassName: SelectSort_2
 * Package: sort
 * Description:
 * ѡ������ => 10�������: spent time: 2456 ms
 * @Author jieHFUT
 * @Create 2024/10/23 23:28
 * @Version 1.0
 */
public class SelectSort_2 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // �������Сֵ�� i ��Ԫ�ؽ���
            swap(i, minIndex, arr);
        }
    }
    // ����һ�����������±�λ�õ�Ԫ�� i j arr
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
