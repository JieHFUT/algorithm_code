package dynamic;

/**
 * ͨ�� ��ֵ/���� ��ʾĳһ����Ʒ��Ȩֵ������ѡ����ƷȨֵ�ϴ��
 */

public class SelfDynamic {
    public static void main(String[] args) {

        // ����һ�����飬��ʾ��Ʒ������
        int[] weight = {1,3,5,3,6,4,7,5};
        // ����һ�����飬��ʾ��Ʒ�ļ�ֵ
        int[] value = {100, 200, 150, 300, 400, 180, 320, 260};
        // ����������
        int capacity = 18;
        // ��Ʒ�ĸ���
        int number = value.length;

//        Map<Integer, Integer> data = new HashMap();
//        for (int i = 0; i < number; i++) {
//            data.put(weight[i], value[i]);
//        }
//        Map<Double, Integer> toChoice = new HashMap();
//        for (int i = 0; i < number; i++) {
//            toChoice.put((double)value[i] / (double)weight[i], weight[i]);
//        }

        double[] toChoice = new double[number];
        for (int i = 0; i < number; i++) {
            toChoice[i] = (double) value[i] / (double) weight[i];
        }




    }
}
