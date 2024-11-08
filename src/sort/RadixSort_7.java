package sort;

import java.util.Arrays;

/**
 * ClassName: Radix
 * Package: sort
 * Description:
 * Ͱ���� Ҳ�л������� 23ms
 * @Author jieHFUT
 * @Create 2024/10/24 23:22
 * @Version 1.0
 */
public class RadixSort_7 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100_000);
        }
        long start = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("spent: " + (end - start) + "ms");
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {

        int[][] bucket = new int[10][arr.length];
        int[] bucketIndexNumber = new int[bucket.length];

        // ����������������ֵ�λ��
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int enlarged = 1;
        int maxNum = (max + "").length();
        for (int k = 0; k < maxNum; k++, enlarged *= 10) {
            // ���������λ��ʮλ����λ
            // ����ʮ����... λ��������
            for (int i = 0; i < arr.length; i++) {
                // ��ø�����ĵ� i ��Ԫ�صĸ�λ��
                int digit = (arr[i] / enlarged) % 10;
                // �������ַŽ���Ӧ��Ͱ��
                bucket[digit][bucketIndexNumber[digit]] = arr[i];
                bucketIndexNumber[digit]++;
            }
            // ��ʱ�����е������Ѿ�ȫ����Ͱ����Ͱ�е�����ȫ���ó��Ż�������
            int recodeArr = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketIndexNumber[i] > 0) {
                    // ˵���� i ��Ͱ��������
                    for (int j = 0; j < bucketIndexNumber[i]; j++) {
                        // ���±�Ϊ 0 ��λ�������ݣ��� bucketIndexNumber[i] ��
                        arr[recodeArr++] = bucket[i][j];
                    }
                }
                bucketIndexNumber[i] = 0;
            }
        }


    }
}
