package recursion;

public class RecursionTest {
    public static void main(String[] args) {
        // ����һ�����ֵĽ׳�
        System.out.printf("%d�Ľ׳���:%d.", 5, recursionNum(5));
    }
    public static int recursionNum(int num) {
        if (num == 0 || num == 1) {
            return num;
        } else {
            return num * recursionNum(num - 1);
        }
    }
}
