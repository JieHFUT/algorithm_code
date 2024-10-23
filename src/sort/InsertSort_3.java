package sort;

import java.util.Arrays;

/**
 * ClassName: InsertSort_3
 * Package: sort
 * Description:
 * 插入排序 => 10万个数据: spent time: 1509 ms
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
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("第"+i+"轮插入");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
