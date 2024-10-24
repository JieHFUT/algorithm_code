package sort;

// 归并排序
public class MergeSort_6 {
    public static void main(String[] args) {


    }
    // 归并排序的合并方法
    public static void mergeSort(int[] arr, int left, int mid, int right, int[] ret) {
        int i = left;
        int count = 0;
        int j = mid + 1;
        // 可以考虑现在是两个有序数组 一个是arr[0 => mid] 一个是arr[mid+1 => right]
        while(i <= mid && j <= right) {
            if(i == mid) {
                while(j <= right) {
                    ret[count] = arr[j];
                    count++;
                    j++;
                    break;
                }
            }
            if(j == right) {
                while(i <= mid) {
                    ret[count] = arr[i];
                    count++;
                    i++;
                    break;
                }
            }
            // 两个有序数组都还没有到头
            if(arr[i] < arr[j]) {
                // 将较小的加入到零时数组中
                ret[count] = arr[i];
                count++;
                i++;
            } else {
                ret[count] = arr[j];
                count++;
                j++;
            }
        }
        // 已经将 arr 中数据在 ret 中有序放置
        arr = ret;



    }
}
