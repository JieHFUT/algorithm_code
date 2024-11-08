package greedy;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: Greedy
 * Package: greedy
 * Description:
 * ̰���㷨
 * @Author jieHFUT
 * @Create 2024/11/5 21:27
 * @Version 1.0
 */
public class Greedy {

    public static void main(String[] args) {
        // �����㲥����̨
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> first = new HashSet<>();
        first.add("����");
        first.add("�Ϻ�");
        first.add("���");
        HashSet<String> second = new HashSet<>();
        second.add("����");
        second.add("����");
        second.add("����");
        HashSet<String> third = new HashSet<>();
        third.add("�ɶ�");
        third.add("�Ϻ�");
        third.add("����");
        HashSet<String> fourth = new HashSet<>();
        fourth.add("�Ϻ�");
        fourth.add("���");
        HashSet<String> fifth = new HashSet<>();
        fifth.add("����");
        fifth.add("����");
        // ����������̨���뵽 boardcasts
        map.put("first", first);
        map.put("second", second);
        map.put("third", third);
        map.put("fourth", fourth);
        map.put("fifth", fifth);

        // ����һ���ܵ�ӵ��ȫ��������set
        HashSet<String> all = new HashSet<>();
        all.add("����");
        all.add("�Ϻ�");
        all.add("���");
        all.add("����");
        all.add("����");
        all.add("�ɶ�");
        all.add("����");
        all.add("����");


        // ����һ��������Ž����
        List<String> result = new ArrayList();
        // ������¼һ�����ҵ��ĸ���δ���ǵ������������Ĺ㲥̨���Ǽ�������
        HashSet<String> temp = new HashSet<>();
        HashSet<String> temp1 = new HashSet<>();
        // ����׷��ĳһ��ѡ��㲥̨�� => ����δ���ǵ������������Ĺ㲥̨
        String maxNumber = null;


        while (all.size() != 0) {
            maxNumber = null;
            // һ��ѭ�����һ���㲥����̨��ȥ��ʣ����ܹ��������δ���ǵ����Ĺ㲥����̨

            // number �ڼ����㲥����̨�����ƣ������㲥����̨
            for (String number : map.keySet()) {
                temp.clear();
                temp1.clear();
                // �õ�ĳһ���㲥����̨�ܹ����ǵ�����
                HashSet areas = map.get(number);
                temp.addAll(areas);
                // �õ�ĳһ���㲥����̨�ܹ����ǵ�δ���ǵ�����
                temp.retainAll(all);
                // �ҵ�����
                if (maxNumber != null) {
                    HashSet maxAreas = map.get(maxNumber);
                    temp1.addAll(maxAreas);
                    temp1.retainAll(areas);
                }

                if (temp.size() > 0 &&
                        (maxNumber == null || temp.size() > temp1.size())){
                    maxNumber = number;
                }
            }
            // ������ط��ҵ��˸���δ���ǵ������������Ĺ㲥̨
            // ȥ���ҵ�������
            if (maxNumber != null) {
                result.add(maxNumber);
                all.removeAll(map.get(maxNumber));
            }
        }


        for (String res : result) {
            System.out.print(res + " ");
        }
        System.out.println();

    }


    @Test
    public void test(){

        // �����㲥����̨
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> first = new HashSet<>();
        first.add("����");
        first.add("�Ϻ�");
        first.add("���");
        HashSet<String> second = new HashSet<>();
        second.add("����");
        second.add("����");
        second.add("����");
        HashSet<String> third = new HashSet<>();
        third.add("�ɶ�");
        third.add("�Ϻ�");
        third.add("����");
        HashSet<String> fourth = new HashSet<>();
        fourth.add("�Ϻ�");
        fourth.add("���");
        HashSet<String> fifth = new HashSet<>();
        fifth.add("����");
        fifth.add("����");
        // ����������̨���뵽 boardcasts
        map.put("first", first);
        map.put("second", second);
        map.put("third", third);
        map.put("fourth", fourth);
        map.put("fifth", fifth);

        // ����һ���ܵ�ӵ��ȫ��������set
        HashSet<String> all = new HashSet<>();
        all.add("����");
        all.add("�Ϻ�");
        all.add("����");
        all.add("����");
        all.add("�ɶ�");
        all.add("����");
        all.add("����");

        //
        map.get("first").retainAll(all);

        HashSet set = map.get("first");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // �Ϻ�
        // ����
    }

}
