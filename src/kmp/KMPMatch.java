package kmp;

import java.util.Arrays;

public class KMPMatch {
    public static void main(String[] args) {

        int[] next = kmpNext("ABCDABD");
        System.out.println("next=" + Arrays.toString(next));

    }

//    public static int[] kmpNext(String dest) {
//        int[] next = new int[dest.length()];
//        next[0] = 0;
//        // i 指向 dest 的某一个字符， j 指向
//        for (int i = 0, j = 0; i < next.length; i++) {
//            // 此处的字符串的长度为 i
//            //
//            if (j > 0 && dest.charAt(i) != dest.charAt(j)) {
//
//            }
//
//            // 如果指向的字符和前面的一样
//            if (dest.charAt(i) == dest.charAt(j)) {
//                j++;
//            }
//
//        }
//    }

    //获取到一个字符串(子串) 的部分匹配值表
    public static  int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        for(int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
