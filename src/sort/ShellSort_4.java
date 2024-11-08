package sort;

import java.util.Arrays;

// ϣ������ => Ҳ����Ϊ��С�������� => �ǲ�������ĸĽ���
// ϣ������(����ʽ) => 10�������: spent time: 7234 ms
// ϣ������(����ʽ) => 10�������: spent time: 23 ms
public class ShellSort_4 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        // System.out.println(Arrays.toString(arr));

    }
    // ϣ������ => ������
    public static void shellSort(int[] arr) {
        // �Ƚ������Ϊ arr.length / 2 ��
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            count++;
            // ��������ǰ��Ԫ�ضԱȣ�С�ķ�����ǰ�� => ����ʽ
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        // ����������Ԫ��
                        swap(arr, j, j + gap);
                    }
                }
            }
            // System.out.println("��" + count + "�ֵĽ����: " + Arrays.toString(arr));
        }
    }
    // ϣ������ => ��λ��
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int toInsert = arr[i];
                for (j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > toInsert) {
                        // ����Ҫ����ֵ�����ݺ���
                        arr[j + gap] = arr[j];
                    } else {
                        // �ҵ������
                        arr[j + gap] = toInsert;
                        break;
                    }
                }
                if(j < 0) {
                    arr[j + gap] = toInsert;
                }
            }
        }
    }
    // ��������Ԫ��
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
