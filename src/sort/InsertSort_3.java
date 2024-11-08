package sort;

import java.util.Arrays;

/**
 * ClassName: InsertSort_3
 * Package: sort
 * Description:
 * �������� => 10�������: spent time: 1509 ms
 *                     spent time: 3640 ms
 * @Author jieHFUT
 * @Create 2024/10/23 23:56
 * @Version 1.0
 */
public class InsertSort_3 {
    public static void main(String[] args) {

        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = i;
            arr[i] = (int) (Math.random() * 100_000); // [0, 1) * 100_000
        }
        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("spent time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // ������ n -1 ��Ԫ�����β���ǰ�������, ��ʱ�ǵ� i+1 ��Ԫ��
            int j = 0;
            int toInsert = arr[i + 1];
            for (j = i; j >= 0; j--) {
                // ��ǰ�� i ��Ԫ�����αȶ�
                if (arr[j] > toInsert) {
                    // ��������Ԫ��
                    arr[j + 1] = arr[j];
                } else {
                    // �ҵ��ò���ĵ㣬������Ԫ���Ѿ����κ�����
                    arr[j + 1] = toInsert;
                    break;
                }
            }
            // ������������������б������Ԫ�ض��� toInsert ��
            if (j == -1) {
                arr[j + 1] = toInsert;
            }
        }
    }




    public static void insertSort1(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //ʹ��forѭ�����Ѵ����
        for (int i = 1; i < arr.length; i++) {
            //������������
            insertVal = arr[i];
            insertIndex = i - 1; // ��arr[1]��ǰ����������±�

            // ��insertVal �ҵ������λ��
            // ˵��
            // 1. insertIndex >= 0 ��֤�ڸ�insertVal �Ҳ���λ�ã���Խ��
            // 2. insertVal < arr[insertIndex] �������������û���ҵ�����λ��
            // 3. ����Ҫ�� arr[insertIndex] ����
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // ���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + 1
            // ��������ⲻ�ˣ�����һ�� debug
            //���������ж��Ƿ���Ҫ��ֵ
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("��"+i+"�ֲ���");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
