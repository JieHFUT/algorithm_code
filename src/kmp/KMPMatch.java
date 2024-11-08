package kmp;

import java.util.Arrays;

public class KMPMatch {
    public static void main(String[] args) {

        String dest = "ABCDABD";
        String toMatch = "BBC ABCDAB ABCDABCDABDE";

        int[] next = kmpNext(dest);
        System.out.println("next=" + Arrays.toString(next));
        int ret = kmpMatch(toMatch, dest, next);
        System.out.println("返回值：index=" + ret);

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
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            // 如果说此时的元素等于之前匹配的后一个
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static int kmpMatch(String toMatch, String dest, int[] next) {
        for (int i = 0, j = 0; i < toMatch.length(); i++) {
            //
            while (j > 0 && toMatch.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            if (toMatch.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }



}
