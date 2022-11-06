package kmp;

import java.util.Arrays;

/**
 * KMP在mp算法的基础上，减少了回溯失败次数
 */
public class KMP {
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
                if (j == 0 || pmt[j - 1] == 0) {
                    i++;
                    j = 0;
                } else {
                    j = pmt[j - 1];
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
                if (i + 1 < pmt.length && pattern.charAt(i + 1) == pattern.charAt(j + 1)) {
                    // KMP优化的地方
                    pmt[i] = pmt[j];
                    ++i;
                    ++j;
                } else {
                    pmt[i] = ++j;
                    i++;
                }
            } else {
                if (j == 0) i++;
                j = 0;
            }
        }
        return pmt;
    }
}
