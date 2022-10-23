package kmp;

import java.util.Arrays;

public class MP {
    public static void main(String[] args) {
        System.out.println(getFirstMatch("ababccsababccdf", "ababccd"));
    }

    private static int getFirstMatch(String str, String pattern) {
        int i = 0;
        int j = 0;
        int[] pmt = getPmt(pattern);
        System.out.println(Arrays.toString(pmt));
        while (i < str.length() && j < pattern.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0 || pmt[j = 1] == 0) {
                    i++;
                    j = 0;
                } else {
                    j -= pmt[j - 1];
                }
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getPmt(String pattern) {
        int[] pmt = new int[pattern.length()];
        int i = 1;
        int j = 0;
        while (i < pmt.length && j < pmt.length) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pmt[i] = ++j;
                i++;
            } else {
                if (j == 0) i++;
                j = 0;
            }
        }
        return pmt;
    }
}
