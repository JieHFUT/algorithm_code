package sort;

import java.util.Arrays;

// �������� 24ms
public class QuickSort_5 {
    public static void main(String[] args) {
//        int[] arr = new int[]{23,4,6,76,546,45,43,4,35,45,45,65,7,65,34,123,8};
//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int leftKey, int rightKey) {
        int left = leftKey;
        int right = rightKey;
        // ѡȡһ����׼��������ķ����ұߣ�����С�ķ������ (�������м��Ԫ��Ϊ��׼����: ���� pivot)
        int pivot = (right + left) / 2;
        int toCompare = arr[pivot];
        while (left < right) {
            while (arr[left] < toCompare) {
                left++;
            }
            while (arr[right] > toCompare) {
                right--;
            }
            if (left >= right) {
                // ���������ѽ���
                break;
            }
            // ������ط���arr[left] >= arr[right]  => ����
            swap(arr, left, right);

            if(arr[left] == toCompare)
                right--;
            if (arr[right] == toCompare)
                left++;
        }
        if(left == right) {
            left++;
            right--;
        }
        // ����߱Ȼ�׼С���ٴ�����
        if (leftKey < right)
            quickSort(arr, leftKey, right);
        // ���ұ߱Ȼ�׼����ٴ�����
        if (left < rightKey)
            quickSort(arr, left, rightKey);
    }
    // ����
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
