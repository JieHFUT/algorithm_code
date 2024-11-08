package search;

/**
 * ClassName: BinarySearch_2
 * Package: search
 * Description:
 * ���ֲ���
 * @Author jieHFUT
 * @Create 2024/10/25 2:24
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ��� mid ��������Ҫ�ҵ�Ŀ�꣬���� mid
 * ��� mid ��ֵС�� target, �����ұ߱���
 * ��� mid ��ֵ���� target, ������߱���
 * ��������껹û���ҵ��ͷ��� -1
 */
public class BinarySearch_2 {
    public static void main(String[] args) {
        // ��Ҫһ�����������
        int[] arr = new int[100_000_000];
        for (int i = 0; i < 100_000_000; i++) {
            arr[i] = i + 1;
        }
        long start = System.currentTimeMillis();
        int ret = binarySearch(arr, (int)(Math.random() * 100_000_000));
        long end = System.currentTimeMillis();
        System.out.println("ret=" + ret + "   " + (end - start) + "ms");

//        int[] arr = new int[]{1,2,3,4,5,6,6,6,6,6,6,7,8,9,61};
//        long start = System.currentTimeMillis();
//        List<Integer> result = binarySearchFindAll(arr, 6);
//        long end = System.currentTimeMillis();
//        Iterator iterator = result.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("spent " + (end - start) + "ms");

    }



    // ���ص�һ������Ҫ������ֵ��±�
    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }
    public static int binarySearch(int[] arr, int left, int right, int target) {

        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, right, target);
        } else {
            return binarySearch(arr, left, mid - 1, target);
        }
    }














    /**
     * �������еĵ��� target ���±�
     * ���ҵ� mid ��ֵ��ʱ��Ҫ���Ϸ���
     * �� mid ����ֵ�����ɨ�裬����������Ҫ���ȫ�����뼯�ϣ������ұ�ɨ��
     * {1,2,3,4,5,6,6,6,6,6,6,7,8,9,61}
     *               mid
     *            6,5,7,8,9,10
     * @param arr
     * @param target
     * @return
     */
    public static List<Integer> binarySearchFindAll(int[] arr, int target) {
        return binarySearchFindAll(arr, 0, arr.length - 1, target);
    }
    public static List<Integer> binarySearchFindAll(int[] arr, int left, int right, int target) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            List<Integer> list = new ArrayList<>();
            // ����
            int leftIndex = mid - 1;
            while (leftIndex >= 0 && arr[leftIndex] == target) {
                list.add(leftIndex);
                leftIndex--;
            }
            list.add(mid);
            // ����
            int rightIndex = mid + 1;
            while (rightIndex < arr.length && arr[rightIndex] == target) {
                list.add(rightIndex);
                rightIndex++;
            }
            return list;
        }
        else if (arr[mid] < target)
            return binarySearchFindAll(arr, mid+1, right, target);
        else
            return binarySearchFindAll(arr, left, mid - 1, target);
    }
}
