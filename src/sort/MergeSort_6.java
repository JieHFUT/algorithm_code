package sort;

import java.util.Arrays;

// �鲢���� wrong
public class MergeSort_6 {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(arr));
    }






    // ��
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);

    }
    // �鲢����ĺϲ�����
    public static void merge(int[] arr, int left, int mid, int right, int[] ret) {
        /**
         * [2,6,3,4,7,2,6,9]
         *  2 6   3 4
         *  2 3 4 6
         * ����ֻ��Ҫ���� left �� right �����ݾͿ�����
         */
        int i = left;
        int count = 0;
        int j = mid + 1;
        // ���Կ��������������������� һ����arr[0 => mid] һ����arr[mid+1 => right]
        while(i <= mid && j <= right) {
            // �����������鶼��û�е�ͷ
            if(arr[i] < arr[j]) {
                // ����С�ļ��뵽��ʱ������
                ret[count] = arr[i];
                count++;
                i++;
            } else {
                ret[count] = arr[j];
                count++;
                j++;
            }
        }
        // �Ѿ���ĳһ�����鵽ͷ��
        if(i == mid) {
            while(j <= right) {
                ret[count] = arr[j];
                count++;
                j++;
            }
        }
        if(j == right) {
            while(i <= mid) {
                ret[count] = arr[i];
                count++;
                i++;
            }
        }
        // �Ѿ��� arr �������� ret ��������ã�������ÿ�ζ����� 8 ��
        count = 0;
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = ret[count];
            count++;
            tempLeft++;
        }
    }
}
