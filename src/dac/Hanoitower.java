package dac;

/**
 * ClassName: Hanoitower
 * Package: dac
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/4 18:56
 * @Version 1.0
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5, "F", "S", "T");
    }


    /**
     * 汉诺塔
     * @param level  塔的层数
     * @param first  第一座塔名
     * @param second 第二座塔名
     * @param third  第三座塔名
     */
    public static void hanoitower(int level, String first, String second, String third) {
        if (level <= 0) throw new RuntimeException("Invalid level");
        if (level == 1)
            System.out.println("第" + level + "层 => 从" + first + "塔移动到" + third + "塔");
        else {
            // 大于等于两层塔


            // 1. 将上面的 n-1 层移动到中间的塔上
            hanoitower(level - 1, first, third, second);

            // 2. 将最下面的一层移动到右边的塔上
            System.out.println("第" + level + "层 => 从" + first + "塔移动到" + third + "塔");

            // 3. 再将中间的 n-1 层移动到最右边的塔上
            hanoitower(level - 1, second, first, third);
        }
    }
}
