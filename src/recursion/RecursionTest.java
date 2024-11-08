package recursion;

public class RecursionTest {
    public static void main(String[] args) {
        // 计算一个数字的阶乘
        System.out.printf("%d的阶乘是:%d.", 5, recursionNum(5));
    }
    public static int recursionNum(int num) {
        if (num == 0 || num == 1) {
            return num;
        } else {
            return num * recursionNum(num - 1);
        }
    }
}
