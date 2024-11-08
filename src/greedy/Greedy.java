package greedy;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: Greedy
 * Package: greedy
 * Description:
 * 贪心算法
 * @Author jieHFUT
 * @Create 2024/11/5 21:27
 * @Version 1.0
 */
public class Greedy {

    public static void main(String[] args) {
        // 创建广播电视台
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> first = new HashSet<>();
        first.add("北京");
        first.add("上海");
        first.add("天津");
        HashSet<String> second = new HashSet<>();
        second.add("广州");
        second.add("北京");
        second.add("深圳");
        HashSet<String> third = new HashSet<>();
        third.add("成都");
        third.add("上海");
        third.add("杭州");
        HashSet<String> fourth = new HashSet<>();
        fourth.add("上海");
        fourth.add("天津");
        HashSet<String> fifth = new HashSet<>();
        fifth.add("杭州");
        fifth.add("大连");
        // 将各个电视台放入到 boardcasts
        map.put("first", first);
        map.put("second", second);
        map.put("third", third);
        map.put("fourth", fourth);
        map.put("fifth", fifth);

        // 创造一个总的拥有全部地区的set
        HashSet<String> all = new HashSet<>();
        all.add("北京");
        all.add("上海");
        all.add("天津");
        all.add("广州");
        all.add("深圳");
        all.add("成都");
        all.add("杭州");
        all.add("大连");


        // 创造一个用来存放结果的
        List<String> result = new ArrayList();
        // 用来记录一轮中找到的覆盖未覆盖的区域数量最大的广播台的那几个区域
        HashSet<String> temp = new HashSet<>();
        HashSet<String> temp1 = new HashSet<>();
        // 用来追踪某一轮选择广播台中 => 覆盖未覆盖的区域数量最大的广播台
        String maxNumber = null;


        while (all.size() != 0) {
            maxNumber = null;
            // 一次循环添加一个广播电视台，去找剩余的能够覆盖最多未覆盖地区的广播电视台

            // number 第几个广播电视台的名称，遍历广播电视台
            for (String number : map.keySet()) {
                temp.clear();
                temp1.clear();
                // 得到某一个广播电视台能够覆盖的区域
                HashSet areas = map.get(number);
                temp.addAll(areas);
                // 得到某一个广播电视台能够覆盖的未覆盖的区域
                temp.retainAll(all);
                // 找到最大的
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
            // 在这个地方找到了覆盖未覆盖的区域数量最大的广播台
            // 去掉找到的区域
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

        // 创建广播电视台
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> first = new HashSet<>();
        first.add("北京");
        first.add("上海");
        first.add("天津");
        HashSet<String> second = new HashSet<>();
        second.add("广州");
        second.add("北京");
        second.add("深圳");
        HashSet<String> third = new HashSet<>();
        third.add("成都");
        third.add("上海");
        third.add("杭州");
        HashSet<String> fourth = new HashSet<>();
        fourth.add("上海");
        fourth.add("天津");
        HashSet<String> fifth = new HashSet<>();
        fifth.add("杭州");
        fifth.add("大连");
        // 将各个电视台放入到 boardcasts
        map.put("first", first);
        map.put("second", second);
        map.put("third", third);
        map.put("fourth", fourth);
        map.put("fifth", fifth);

        // 创造一个总的拥有全部地区的set
        HashSet<String> all = new HashSet<>();
        all.add("北京");
        all.add("上海");
        all.add("广州");
        all.add("深圳");
        all.add("成都");
        all.add("杭州");
        all.add("大连");

        //
        map.get("first").retainAll(all);

        HashSet set = map.get("first");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 上海
        // 北京
    }

}
