package kmp;

import java.util.Arrays;

public class KMPMatch {
    public static void main(String[] args) {

        String dest = "ABCDABD";
        String toMatch = "BBC ABCDAB ABCDABCDABDE";

        int[] next = kmpNext(dest);
        System.out.println("next=" + Arrays.toString(next));
        int ret = kmpMatch(toMatch, dest, next);
        System.out.println("����ֵ��index=" + ret);

    }



//    public static int[] kmpNext(String dest) {
//        int[] next = new int[dest.length()];
//        next[0] = 0;
//        // i ָ�� dest ��ĳһ���ַ��� j ָ��
//        for (int i = 0, j = 0; i < next.length; i++) {
//            // �˴����ַ����ĳ���Ϊ i
//            //
//            if (j > 0 && dest.charAt(i) != dest.charAt(j)) {
//
//            }
//
//            // ���ָ����ַ���ǰ���һ��
//            if (dest.charAt(i) == dest.charAt(j)) {
//                j++;
//            }
//
//        }
//    }

    //��ȡ��һ���ַ���(�Ӵ�) �Ĳ���ƥ��ֵ��
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            // ���˵��ʱ��Ԫ�ص���֮ǰƥ��ĺ�һ��
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
