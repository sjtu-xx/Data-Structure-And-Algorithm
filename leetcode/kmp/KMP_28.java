package leetcode.kmp;

import java.util.Arrays;

public class KMP_28 {
    private static int[] getPmt(String pattern) {
        int length = pattern.length();
        int[] pmt = new int[length];
        int i = 1;
        int j = 0;
        while (i < length && j < length) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pmt[i] = ++j;
                i++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = pmt[j - 1];
                }
            }
        }
        return pmt;
    }

    private static int kmp(String haystack, String needle) {
        int[] pmt = getPmt(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    if (pmt[j - 1] == 0) {
                        j = 0;
                    } else {
                        j = pmt[j - 1];
                    }
                }
            }
        }
        if (j == needle.length()) return i - needle.length();
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getPmt("aabaaac")));
        System.out.println(kmp("aabaaabaaac", "aabaaac"));
    }
}
