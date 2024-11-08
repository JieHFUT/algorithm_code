package sort;

import java.util.Arrays;

/**
 * ClassName: BubbleSort
 * Package: sort
 * Description:
 * ð������ => 10������ݣ�spent time: 11828 ms
 * @Author jieHFUT
 * @Create 2024/10/23 22:50
 * @Version 1.0
 */
public class BubbleSort_1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[10];
//        for (int i = 0; i < 10; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        bubbleSort1(arr);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(arr));


        int[] arr1 = new int[100_000];
        for (int i = 0; i < arr1.length; i++) {
            // arr1[i] = i;
            arr1[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start1 = System.currentTimeMillis();
        bubbleSort2(arr1);
        long end1 = System.currentTimeMillis();
        System.out.println("spent time: " + (end1 - start1) + " ms");

    }

    public static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // ���һ�����Ⱥ�һ�����󣬽���
                    swap(j, j + 1, arr);
                }
            }
        }
    }


    // ��һ�θĽ�(���ĳһ�������������û�н��н�����˵���Ѿ����򣬽�������)
    public static void bubbleSort2(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    flag = false;
                }
            }
            if (flag)
                break;
            else
                flag = true;
        }
    }
    // �ڶ��θĽ�
    public static void bubbleSort3(int[] arr) {

    }
    // ����һ�����������±�λ�õ�Ԫ�� i j arr
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
