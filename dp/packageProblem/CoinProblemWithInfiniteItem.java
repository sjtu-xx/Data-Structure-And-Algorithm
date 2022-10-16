package dp.packageProblem;

import java.util.Arrays;

public class CoinProblemWithInfiniteItem {
    public static void main(String[] args) {
        // 硬币的价值
        int[] values = {1, 2, 5, 10, 50, 100};
        // 目标的结果
        int targetValue = 6;
        // 最小的数量
        int[] minCount = new int[targetValue + 1];
        for (int i = 1; i < minCount.length; i++) {
            int x = i;
            minCount[i] = Arrays.stream(values)
                    .filter(value -> x - value >= 0)
                    .map(value -> minCount[x - value] + 1)
                    .min()
                    .getAsInt();
        }
        System.out.println(minCount[targetValue]);
    }
}
