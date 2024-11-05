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
    public static  int[] kmpNext(String dest) {
        //����һ��next ���鱣�沿��ƥ��ֵ
        int[] next = new int[dest.length()];
        next[0] = 0; //����ַ����ǳ���Ϊ1 ����ƥ��ֵ����0
        for(int i = 1, j = 0; i < dest.length(); i++) {
            //��dest.charAt(i) != dest.charAt(j) ��������Ҫ��next[j-1]��ȡ�µ�j
            //ֱ�����Ƿ��� ��  dest.charAt(i) == dest.charAt(j)�������˳�
            //��ʱkmp�㷨�ĺ��ĵ�
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            //��dest.charAt(i) == dest.charAt(j) ����ʱ������ƥ��ֵ����+1
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
