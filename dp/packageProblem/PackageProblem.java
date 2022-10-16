package dp.packageProblem;

import java.util.Arrays;

public class PackageProblem {
    public static void main(String[] args) {
        int[] w = new int[]{1, 4, 3};
        int[] v = new int[]{1500, 3000, 2000};
        int capacity = 8;
        int itemCount = w.length;

        // 有前i个物品，背包总重量为j时，背包中可以放入的最大容量
        int[][] maxValue = new int[itemCount + 1][capacity + 1];
        for (int i = 1; i < maxValue.length; i++) {
            for (int j = 1; j < maxValue[0].length; j++) {
                if (w[i - 1] > j) {
                    // 如果物品的重量大于背包容量，那就用相同重量下，没有这种物品的最大物品价值作为最大价值。
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    // 如果物品重量小于背包容量，就试着放进背包
                    // 物品i放进去的价值
                    int m1 = maxValue[i - 1][j - w[i - 1]] + v[i - 1];
                    // 物品i不放进去的价值
                    int m2 = maxValue[i - 1][j];
                    maxValue[i][j] = Math.max(m1, m2);
                }
            }
        }
        for (int[] ints : maxValue) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
