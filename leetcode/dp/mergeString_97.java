package leetcode.dp;

/**
 * @author xuexuan
 * @date 2022-11-07 22:50:24
 */
public class mergeString_97 {
    public static void main(String[] args) {
        new mergeString_97().isInterleave("", "", "");
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();
        if (s1Length + s2Length != s3Length) return false;
        boolean[][] matrix = new boolean[s1Length + 1][s2Length + 1];
        matrix[0][0] = true;
        for (int i = 0; i <= s1Length; i++) {
            for (int j = 0; j <= s2Length; j++) {
                matrix[i][j] = matrix[i][j] || (j > 0 && matrix[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                matrix[i][j] = matrix[i][j] || (i > 0 && matrix[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return matrix[s1Length][s2Length];
    }
}