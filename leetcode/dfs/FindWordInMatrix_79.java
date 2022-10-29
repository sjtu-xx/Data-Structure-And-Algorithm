package leetcode.dfs;

public class FindWordInMatrix_79 {

    public static void main(String[] args) {
        char[][] board = {{'a','c'}};
        String word = "ab";
        System.out.println(new FindWordInMatrix_79().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean[][] visited = new boolean[h][w];
                boolean result = findWordFromLocation(board, visited, word, i, j);
                if (result) return true;
            }
        }
        return false;
    }

    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private boolean findWordFromLocation(char[][] board, boolean[][] visited, String word, int i, int j) {
        if (word.charAt(0) != board[i][j]) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        visited[i][j] = true;

        for (int[] direction : directions) {
            int newI = direction[0] + i;
            int newJ = direction[1] + j;
            if (isValid(newI, newJ, board) && !visited[newI][newJ]) {
                boolean result = findWordFromLocation(board, visited, word.substring(1), newI, newJ);
                if (result) return true;
                visited[newI][newJ] = false;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, char[][] board) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}
