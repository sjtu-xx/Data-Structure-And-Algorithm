package dijkstra;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] weight = {
                {-1, 5, 7, -1, -1, -1, 2},
                {5, -1, -1, 9, -1, -1, 3},
                {7, -1, -1, -1, 8, -1, -1},
                {-1, 9, -1, -1, -1, 4, -1},
                {-1, -1, 8, -1, -1, 5, 4},
                {-1, -1, -1, 4, 5, -1, 6},
                {2, 3, -1, -1, 4, 6, -1}};
        int from = 6;
        int[] preNode=  new Dijkstra().dijkstra(weight, from);
        getMinDis(weight, preNode, from);
    }

    private static void getMinDis(int[][] weight, int[] preNode, int from) {
        for (int i = 0; i < weight.length; i++) {
            if (i==from) continue;
            int dis = 0;
            int cur = i;
            while (preNode[cur] != -1) {
                int to = preNode[cur];
                dis += weight[cur][to];
                cur = to;
            }
            System.out.printf("%d:%d\n", i, dis);
        }
    }


    private int[] dijkstra(int[][] weight, int from) {
        boolean[] visited = new boolean[weight.length];
        Arrays.fill(visited, false);
        visited[from] = true;
        int[] preNode = new int[weight.length];
        Arrays.fill(preNode, -1);
        int[] minDis = new int[weight.length];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[from] = 0;

        int cur = from;
        int tmpMinNode = cur;
        while (!isAllTrue(visited)) {
            visited[tmpMinNode] = true;
            // 更新从新节点开始，到其他节点的最短路径。
            for (int i = 0; i < weight[cur].length; i++) {
                if (weight[cur][i] == -1 || visited[i]) continue;
                int minDistance = minDis[cur] + weight[cur][i];
                if (minDistance < minDis[i]) {
                    minDis[i] = minDistance;
                    preNode[i] = cur;
                }
            }

            // 选择未访问的节点中，最短路径对应的节点。
            int tmpMinValue = Integer.MAX_VALUE;
            for (int i = 0; i < weight.length; i++) {
                if (visited[i]) continue;
                if (minDis[i] < tmpMinValue) {
                    tmpMinValue = minDis[i];
                    tmpMinNode = i;
                }
            }
            cur = tmpMinNode;
        }
        return preNode;
    }

    private boolean isAllTrue(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }
}
