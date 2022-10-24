package floyd;

import java.util.Arrays;

public class Floyd {
    public static void main(String[] args) {
        int[][] weight = {
                {0, 5, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2},
                {5, 0, Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 3},
                {7, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 9, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, 0, 5, 4},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 5, 0, 6},
                {2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 6, 0}};
        new Floyd().floyd(weight);
    }

    int[][] minDis;
    int[][] midNode;

    public void floyd(int[][] weight) {
        // 初始化两个记录矩阵
        // minDis记录两点间的最短距离
        // midNode记录中继节点的编号
        int nodeCount = weight.length;
        minDis = new int[nodeCount][nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            minDis[i] = Arrays.copyOf(weight[i], weight[i].length);
        }

        midNode = new int[nodeCount][nodeCount];
        for (int i = 0; i < midNode.length; i++) {
            Arrays.fill(midNode[i], i);
        }

        // k为中继节点的编号
        for (int k = 0; k < nodeCount; k++) {
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < nodeCount; j++) {
                    if (i != j && i != k && j != k && minDis[i][k] != Integer.MAX_VALUE && minDis[k][j] != Integer.MAX_VALUE) {
                        int tmpDis = minDis[i][k] + minDis[k][j];
                        if (tmpDis < minDis[i][j]) {
                            minDis[i][j] = tmpDis;
                            midNode[i][j] = midNode[k][j];
                        }
                    }
                }
            }
        }
        System.out.println("最短距离");
        print2DArray(minDis);
        System.out.println("中继节点");
        print2DArray(midNode);
    }

    private void print2DArray(int[][] array) {
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
