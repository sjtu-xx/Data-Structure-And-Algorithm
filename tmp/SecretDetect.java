package tmp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xuexuan
 * @date 2022-11-10 21:26:38
 */
public class SecretDetect {
    static int n;
    static int w;
    // 存放  从 x位置，y位置 开始，flag为（1，-1） 时到最后一行的最大值
    public static int[][][] maxValue;
    public static int[] Y_DIRECTIONS = {-1, 0, 1};
    public static final int X_DIRECTION = 1;

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3},
                {8, 9, 10},
                {5, 0, 5},
                {-9, -8, -10},
                {0, 1, 2},
                {5, 4, 6}};
        n = input.length;
        w = 3;
        maxValue = new int[n][w][2];
        fill3dArrayWithMinInteger(maxValue);
        System.out.println(IntStream.range(0, 3).map(i -> SecretDetect.dfs(input, 0, i, 1)).max().getAsInt());
    }

    private static void fill3dArrayWithMinInteger(int[][][] array3d) {
        for (int i = 0; i < array3d.length; i++) {
            for (int j = 0; j < array3d[i].length; j++) {
                Arrays.fill(array3d[i][j], Integer.MIN_VALUE);
            }
        }
    }


    public static int dfs(int[][] matrix, int curX, int curY, int flag) {
        int curVal = flag * matrix[curX][curY];
        // 如果从当前位置出发，且权重为flag的位置的最大值已经求出，直接返回
        if (maxValue[curX][curY][getFlagDimension(flag)] != Integer.MIN_VALUE) {
            return maxValue[curX][curY][getFlagDimension(flag)];
        }
        // 如果是最后一行
        if (curX + 1 >= n) {
            maxValue[curX][curY][getFlagDimension(flag)] = curVal;
            return curVal;
        }
        int max = Integer.MIN_VALUE;
        for (int direction : Y_DIRECTIONS) {
            int newX = curX + X_DIRECTION;
            int newY = curY + direction;
            int newFlag = getNewFlag(flag, curVal);
            if (newY >= 0 && newY <= w - 1 && newX < n) {
                max = Integer.max(max, curVal + dfs(matrix, newX, newY, newFlag));
            }
        }
        maxValue[curX][curY][getFlagDimension(flag)] = max;
        return max;
    }

    private static int getFlagDimension(int flag) {
        return flag == 1 ? 0 : 1;
    }

    private static int getNewFlag(int flag, int cur_val) {
        return cur_val == 0 ? -flag : flag;
    }
}
