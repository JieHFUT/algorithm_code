package kmp;

public class ViolenceMatch {

    public static void main(String[] args) {
        String toMatch = "BBC ABCDAB ABCDABCDABDE";
        String dest = "ABCDABD";

        int ret = violenceMatch(toMatch, dest);
        System.out.println("ret = " + ret);
    }

    public static int violenceMatch(String toMatch, String dest) {
        int i = 0, j = 0;
        while (i < toMatch.length() && j < dest.length()) {
            if (toMatch.charAt(i) == dest.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == dest.length()) {
                return i;
            }
        }
        return -1;
    }






}
