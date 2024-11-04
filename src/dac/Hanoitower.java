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
     * ��ŵ��
     * @param level  ���Ĳ���
     * @param first  ��һ������
     * @param second �ڶ�������
     * @param third  ����������
     */
    public static void hanoitower(int level, String first, String second, String third) {
        if (level <= 0) throw new RuntimeException("Invalid level");
        if (level == 1)
            System.out.println("��" + level + "�� => ��" + first + "���ƶ���" + third + "��");
        else {
            // ���ڵ���������


            // 1. ������� n-1 ���ƶ����м������
            hanoitower(level - 1, first, third, second);

            // 2. ���������һ���ƶ����ұߵ�����
            System.out.println("��" + level + "�� => ��" + first + "���ƶ���" + third + "��");

            // 3. �ٽ��м�� n-1 ���ƶ������ұߵ�����
            hanoitower(level - 1, second, first, third);
        }
    }
}
