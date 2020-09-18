/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 * 解题思路：深度优先搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = dfs(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 函数dfs(i, j, k)判断从(i, j)出发，是否可以搜到函数word[k:]，表示从第k个字符开始
     * 
     * @param board
     * @param visited
     * @param i
     * @param j
     * @param k
     * @param s
     * @return
     */
    public boolean dfs(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true; // 设置状态

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean result = false;
        for (int[] dir : directions) { // 各个方向遍历
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {

                if (!visited[newi][newj]) {
                    boolean flag = dfs(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        // 这个地方不可以直接retur true; 需要状态重置后才可以return
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false; // 状态重置
        return result;
    }
}
// @lc code=end
