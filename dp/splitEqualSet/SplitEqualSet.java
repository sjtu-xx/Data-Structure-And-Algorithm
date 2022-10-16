package dp.splitEqualSet;

import java.util.Arrays;

public class SplitEqualSet {
    public static Boolean canSetBeSplitTo2EqualSumSet(int[] originSet) {
        int sum = Arrays.stream(originSet).sum();
        if (sum % 2 != 0) return false;
        int setSum = sum / 2;

        boolean[][] dp = new boolean[originSet.length + 1][setSum + 1];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, false);
            booleans[0] = true;
        }

        for (int i = 1; i < originSet.length + 1; i++) {
            for (int j = 1; j < setSum + 1; j++) {
                if (originSet[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - originSet[i - 1]];
                }
            }
        }
        return dp[originSet.length][setSum];
    }

    // 因为每一次，只依赖上一行的结果，所以二维数组可以优化为一维数组
    public static Boolean canSetBeSplitTo2EqualSumSet_betterVersion(int[] originSet) {
        int sum = Arrays.stream(originSet).sum();
        if (sum % 2 != 0) return false;
        int setSum = sum / 2;

        boolean[] dp = new boolean[setSum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < originSet.length; i++) {
            for (int j = setSum; j > 1; j--) {
                 if (originSet[i] <= j) {
                    dp[j] = dp[j] || dp[j - originSet[i]];
                }
            }
        }
        return dp[setSum];
    }

    public static void main(String[] args) {
        System.out.println(canSetBeSplitTo2EqualSumSet(new int[]{3, 5, 7, 11, 2}));
        System.out.println(canSetBeSplitTo2EqualSumSet_betterVersion(new int[]{3, 5, 7, 11, 2}));
    }
}
