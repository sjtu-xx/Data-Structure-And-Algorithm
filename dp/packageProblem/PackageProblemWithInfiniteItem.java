package dp.packageProblem;

import java.util.Arrays;

public class PackageProblemWithInfiniteItem {
    public static void main(String[] args) {
        System.out.println(getMaxValue());
        System.out.println(getMaxValue_betterVersion());
    }


    private static int getMaxValue_betterVersion() {
        int[] w = new int[]{1, 4, 3};
        int[] v = new int[]{1500, 3000, 5000};
        int capacity = 8;

        int[] maxValue = new int[capacity + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j >= w[i - 1]) {
                    maxValue[j] = Math.max(maxValue[j - w[i - 1]] + v[i - 1], maxValue[j]);
                }
            }
        }
        return maxValue[capacity];
    }

    private static int getMaxValue() {
        int[] w = new int[]{1, 4, 3};
        int[] v = new int[]{1500, 3000, 5000};
        int capacity = 8;

        int[][] maxValue = new int[w.length + 1][capacity + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j >= w[i - 1]) {
                    maxValue[i][j] = Math.max(maxValue[i][j - w[i - 1]] + v[i - 1], maxValue[i - 1][j]);
                } else {
                    maxValue[i][j] = maxValue[i - 1][j];
                }
            }
        }
        return maxValue[w.length][capacity];
    }
}
